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
public class SewingReportService {
private DataSource ds;

public SewingReportService(DataSource ds) {
	this.ds = ds;
}
public byte[] createSewingReportService() throws Exception{
	InputStream input=getClass().getResourceAsStream("/Reports/sewing_report.jrxml");
	if(input==null) {
		throw new RuntimeException("this file not found in this resource");
	}
	JasperReport jas=JasperCompileManager.compileReport(input);
	try(Connection con=ds.getConnection()){
	 JasperPrint print=JasperFillManager.fillReport(jas,new HashMap<>(),con);
	 return JasperExportManager.exportReportToPdf(print);
	}
}
}
