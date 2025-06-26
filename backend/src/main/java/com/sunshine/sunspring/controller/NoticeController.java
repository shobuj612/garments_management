package com.sunshine.sunspring.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.time.LocalDate;
import java.util.List;
//import java.util.UUID;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
//import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.data.domain.Sort;

import com.sunshine.sunspring.model.Notice;
//import com.sunshine.sunspring.repository.NoticeRepository;
import com.sunshine.sunspring.service.NoticeService;

@RestController
@RequestMapping("/api/notices")
@CrossOrigin( origins="http://localhost:4200")
public class NoticeController {

   
	    private final NoticeService service;

	    public NoticeController(NoticeService service) {
	        this.service = service;
	    }

	    @PostMapping("/upload")
	    public ResponseEntity<Notice> upload(@RequestParam("file") MultipartFile file) {
	        try {
	            Notice saved = service.saveFile(file);
	            return ResponseEntity.ok(saved);
	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }

	    @GetMapping
	    public ResponseEntity<List<Notice>> list() {
	        return ResponseEntity.ok(service.getAllFiles());
	    }
	    
	    @GetMapping("/file/{id}")
	    public ResponseEntity<Resource> getFile(
	            @PathVariable Long id,
	            @RequestParam(required = false, defaultValue = "false") boolean download) throws IOException {

	        Notice fileData = service.getFileById(id);
	        Path filePath = Paths.get(fileData.getFilePath());
	        Resource resource = new UrlResource(filePath.toUri());

	        if (!resource.exists() || !resource.isReadable()) {
	            return ResponseEntity.notFound().build();
	        }

	        String contentType = Files.probeContentType(filePath);
	        if (contentType == null) {
	            contentType = "application/pdf"; // fallback
	        }

	        String disposition = download
	                ? "attachment; filename=\"" + fileData.getFileName() + "\""
	                : "inline; filename=\"" + fileData.getFileName() + "\"";

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(contentType))
	                .header(HttpHeaders.CONTENT_DISPOSITION, disposition)
	                .body(resource);
	    }


	}


