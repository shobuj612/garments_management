package com.sunshine.sunspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.sunspring.service.SewingReportService;

@RestController
@RequestMapping("/api/report")
public class SewingReportController {
	@Autowired private SewingReportService srs;
	@GetMapping("/sew")
	public ResponseEntity<byte[]> createSewingReport() throws Exception{
		byte[] pdf=srs.createSewingReportService();
		HttpHeaders head=new HttpHeaders();
		head.setContentType(MediaType.APPLICATION_PDF);
		head.setContentDispositionFormData("attachment","SewingReport.pdf");
		return new ResponseEntity<>(pdf,head,HttpStatus.OK);
	}

}
