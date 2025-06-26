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
public class CuttingReportService {
	
	// this is for database connection
	
	private DataSource ds;

	public CuttingReportService(DataSource ds) {
		this.ds = ds;
	}
	
	// now make the method to for collectiong jrxml file from the resourece and compile it
	
	public byte[] createCuttingReport() throws Exception{
		
		InputStream input =getClass().getResourceAsStream("/Reports/cutting_report.jrxml");
		
		if(input==null) {
			
			throw new  RuntimeException("this file not foun the the source reports/cutting_report.jrxml");
		}
		
		// this is to compile the report 
		
		JasperReport jas =JasperCompileManager.compileReport(input);
		
		
		try(Connection con=ds.getConnection()){
			
			JasperPrint print=JasperFillManager.fillReport(jas, new HashMap<>(),con);
			
			return JasperExportManager.exportReportToPdf(print);
		}
	}
	
	

}
