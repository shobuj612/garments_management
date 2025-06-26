package com.sunshine.sunspring.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
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

import com.sunshine.sunspring.model.Tender;
import com.sunshine.sunspring.service.TenderService;

@RestController
@RequestMapping("/api/tender")
@CrossOrigin(origins="http://localhost:4200")
public class TenderController {
	private  TenderService ts;

	public TenderController(TenderService ts) {
		this.ts = ts;
	}
	//get all the tender from the database
	@GetMapping
	public ResponseEntity<List<Tender>> getAllTenderByController(){
		return ResponseEntity.ok(ts.getAllTender());
	}
	//this is the method to post data in the database
	@PostMapping("/upload")
	public ResponseEntity<Tender> postTenderByController(@RequestParam("file") MultipartFile file){
		try {
			//Tender tender=ts.saveFileInFolder(file);
			return ResponseEntity.ok(ts.saveFileInFolder(file));
		}
		catch(IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	// this is the get from  in the database by the id
	@GetMapping("/file/{id}")
	public ResponseEntity<Resource> getTenderByIdByController(
			@PathVariable Long id, @RequestParam(required=false,defaultValue="false") boolean download)throws IOException{
		
		Tender getFile=ts.getTenderById(id);
		Path createFilePath=Paths.get(getFile.getFilePath());
		Resource resource=new UrlResource(createFilePath.toUri());
		
		if(!resource.exists() || !resource.isReadable()) {
			return ResponseEntity.notFound().build();
		}
		
		String contentType=Files.probeContentType(createFilePath);
		if(contentType==null) {
			contentType="application/pdf";
		}
		
		 String dis=download?"attachment;filename=\""+getFile.getFileName()+"\""
				 :"inline;filename=\""+getFile.getFileName()+"\"";
		 return ResponseEntity.ok()
				 .contentType(MediaType.parseMediaType(contentType))
		         .header(HttpHeaders.CONTENT_DISPOSITION,dis)
		         .body(resource);
	}
}
