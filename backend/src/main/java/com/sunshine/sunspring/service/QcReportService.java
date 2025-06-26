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
public class QcReportService {
private DataSource ds;

public QcReportService(DataSource ds) {
	this.ds = ds;
}
public byte[] creteQcReportService() throws Exception{
	InputStream input=getClass().getResourceAsStream("/Reports/qc_report.jrxml");
	if(input==null) {
		throw new RuntimeException("this file not found");
	}
	JasperReport jas=JasperCompileManager.compileReport(input);
	try(Connection con=ds.getConnection()){
		JasperPrint print=JasperFillManager.fillReport(jas,new HashMap<>(),con);
		return JasperExportManager.exportReportToPdf(print);
	}
}
}
