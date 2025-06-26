package com.sunshine.sunspring.service;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class OrderReportService {
	
	private final DataSource dataSource;
    // this is consturctor injection
	public OrderReportService(DataSource dataSource) {
	
		this.dataSource = dataSource;
	}
	
	public byte[] orderReport() throws Exception {
		
		InputStream inputStream =getClass().getResourceAsStream("/Reports/order_reports.jrxml");
		
		if(inputStream == null) {
			
			throw new RuntimeException("jasper report not found in the resource/reports");
		}
		// this is to compile the .jrxml file
		JasperReport jas =JasperCompileManager.compileReport(inputStream);
		
		try(Connection con=dataSource.getConnection()){
			
			// this is the print method
			
			JasperPrint jsprint=JasperFillManager.fillReport(jas,new HashMap<>(),con);
			
			return JasperExportManager.exportReportToPdf(jsprint);
			
		}
		
		
	}
	
	

}
