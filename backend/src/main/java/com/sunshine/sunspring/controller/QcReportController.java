package com.sunshine.sunspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.sunspring.service.QcReportService;

@RestController
@RequestMapping("api/report")
public class QcReportController {
@Autowired private QcReportService qrs;
@GetMapping("/qc")
public ResponseEntity<byte[]> callQcReportService() throws Exception{
	byte[] pdf=qrs.creteQcReportService();
	HttpHeaders head=new HttpHeaders();
	head.setContentType(MediaType.APPLICATION_PDF);
	head.setContentDispositionFormData("attachment", "QcReport.pdf");
	return new ResponseEntity<>(pdf,head,HttpStatus.OK);
}
}
