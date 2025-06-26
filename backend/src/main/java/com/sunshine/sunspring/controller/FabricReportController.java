package com.sunshine.sunspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.sunspring.service.FabricReportService;

@RestController
@RequestMapping("/api/report")
public class FabricReportController {
	
	@Autowired private FabricReportService frs;
	@GetMapping("/fabric")
	public ResponseEntity<byte[]> callFabricReportService() throws Exception{
		
		byte[] pdf=frs.createFabricReport();
		
		HttpHeaders h=new HttpHeaders();
		
		h.setContentType(MediaType.APPLICATION_PDF);
		h.setContentDispositionFormData("attachment", "FabricReport.pdf");
		
		return new ResponseEntity<>(pdf,h,HttpStatus.OK);
	}

}
