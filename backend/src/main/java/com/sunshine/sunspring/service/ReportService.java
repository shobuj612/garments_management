package com.sunshine.sunspring.service;

import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;

import net.sf.jasperreports.engine.*;

@Service
public class ReportService {

    private final DataSource dataSource;

    public ReportService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public byte[] exportBuyerReport() throws Exception {
        // 1. Load the .jrxml file from resources
        InputStream reportStream = getClass().getResourceAsStream("/reports/buyer_report.jrxml");
        if (reportStream == null) {
            throw new RuntimeException("Jasper report file not found in resources/reports/");
        }

        // 2. Compile the report
        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        // 3. Get DB connection
        try (Connection connection = dataSource.getConnection()) {

            // 4. Fill the report with data
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), connection);

            // 5. Export the report to PDF and return
            return JasperExportManager.exportReportToPdf(jasperPrint);
        }
    }
}
