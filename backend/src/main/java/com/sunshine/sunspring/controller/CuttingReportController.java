package com.sunshine.sunspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.sunspring.service.CuttingReportService;

@RestController
@RequestMapping("/api/report")
public class CuttingReportController {
	
	@Autowired private CuttingReportService crs;
	
	// this is the method  to call the service method
	@GetMapping("/cut")
	public ResponseEntity<byte[]> callCuttingService() throws Exception{
		
		byte[] pdf=crs.createCuttingReport();
		
		HttpHeaders head =new HttpHeaders();
		
		head.setContentType(MediaType.APPLICATION_PDF);
		head.setContentDispositionFormData("attachment", "CuttingReport.pdf");
		return new ResponseEntity<>(pdf,head,HttpStatus.OK);
	}

}
