package com.sunshine.sunspring.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sunshine.sunspring.model.Circuler;
import com.sunshine.sunspring.repository.CirculerRepository;

@Service
public class CirculerService {
	@Value("${file.upload-dir")
	private String uploadDir;
	private final CirculerRepository cr;
	public CirculerService(CirculerRepository cr) {
		this.cr = cr;
	}
	// this is method to get all the circular from the database
	public List<Circuler> getAllCirculerByService(){
		return cr.findAll();
	}
	
	// this is the method to post in the database
	public Circuler getByIdByService(Long id) {
		return cr.findById(id).orElseThrow(()-> new RuntimeException("this file not exiet in the folderr"));
	}
	// this is method to post file path in the database but actual file in the another folder
	public Circuler postFileByService(MultipartFile file) throws IOException{
		//now create the path 
		Path filePath=Paths.get(uploadDir);
		if(!Files.exists(filePath)) {
			Files.createDirectories(filePath);
		}
		// create the file name
		String fileName=UUID.randomUUID()+"_"+file.getOriginalFilename();
		// create full path such as folder name + file name
		Path fullFilePath=filePath.resolve(fileName);
		// to store the file in the folder
		Files.copy(file.getInputStream(), fullFilePath, StandardCopyOption.REPLACE_EXISTING);
		Circuler circuler=new Circuler();
		circuler.setFileName(file.getOriginalFilename());
		circuler.setFilePath(fullFilePath.toString());
		return cr.save(circuler);
	}

}
