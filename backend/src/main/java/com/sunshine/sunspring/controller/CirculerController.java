package com.sunshine.sunspring.controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sunshine.sunspring.model.Circuler;
import com.sunshine.sunspring.service.CirculerService;

@RestController
@RequestMapping("/api/circuler")
@CrossOrigin(origins="http://localhost:4200")
public class CirculerController {
 private final CirculerService cs;

public CirculerController(CirculerService cs) {
	this.cs = cs;
}
 // this is the method to post the data in the database

@PostMapping("/upload")
public ResponseEntity<Circuler> upload(@RequestParam("file") MultipartFile file){
	try {
		Circuler circuler=cs.postFileByService(file);
		return ResponseEntity.ok().body(circuler);
	}
	catch(IOException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
// this is the method to get all data from the datbase
@GetMapping
public ResponseEntity<List<Circuler>> getByController(){
	return ResponseEntity.ok(cs.getAllCirculerByService());
}
// thi is the method to get the file and also show in the browser
@GetMapping("/file/{id}")
public ResponseEntity<Resource> getByIdByController(@PathVariable Long id,@RequestParam(required=false,defaultValue="false") boolean download) throws IOException{
	Circuler circuler=cs.getByIdByService(id);
	Path filePath=Paths.get(circuler.getFilePath());
	Resource resource =new UrlResource(filePath.toUri());
	if(!resource.exists()|| !resource.isReadable()) {
		return ResponseEntity.notFound().build();
	}
	String contentType=Files.probeContentType(filePath);
	if(contentType==null) {
		contentType="application/pdf";
	}
	String dis=download?
			"attachment;fileName=\""+circuler.getFileName()+"\""
			:"inline;fileName=\""+circuler.getFileName()+"\"";
	return ResponseEntity.ok()
			.contentType(MediaType.parseMediaType(contentType))
			.header(HttpHeaders.CONTENT_DISPOSITION,dis)
			.body(resource);
}

}
