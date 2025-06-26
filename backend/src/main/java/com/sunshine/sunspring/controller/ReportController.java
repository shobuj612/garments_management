package com.sunshine.sunspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.sunspring.service.ReportService;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/buyer")
    public ResponseEntity<byte[]> getBuyerReport() throws Exception {
        byte[] pdf = reportService.exportBuyerReport();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "BuyerReport.pdf");

        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }
} 