package com.sunshine.sunspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.sunspring.service.DesignReportService;

@RestController
@RequestMapping("/api/report")
public class DesignReportController {
	
	@Autowired private DesignReportService drs;
	
	@GetMapping("/design")
	public ResponseEntity<byte[]> callDesignReportService() throws Exception{
		
		byte[] pdf=drs.createDesignReport();
		
		HttpHeaders head=new HttpHeaders();
		head.setContentType(MediaType.APPLICATION_PDF);
		head.setContentDispositionFormData("attachment", "DesignReport.pdf");
		
		return new ResponseEntity<>(pdf,head,HttpStatus.OK);
		
	}
	
	}
