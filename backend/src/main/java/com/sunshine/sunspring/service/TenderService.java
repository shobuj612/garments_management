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

import com.sunshine.sunspring.model.Tender;
import com.sunshine.sunspring.repository.TenderRepository;

@Service
public class TenderService {
	@Value("${file.upload-dir}")
	private String uploadDir;
	private  final TenderRepository tr;

	public TenderService(TenderRepository tr) {
		this.tr = tr;
	}
	
	 // this is the method to save the file in he folder not in the database
	public Tender saveFileInFolder(MultipartFile file) throws IOException{
		//now make a path for the file
		Path filePath=Paths.get(uploadDir);// this is take the path or create it
		if(!Files.exists(filePath)) {
			Files.createDirectories(filePath);
		}
		//new create the unique file name by uuid
		String fileName=UUID.randomUUID()+"_"+file.getOriginalFilename();
		Path fullFilePath=filePath.resolve(fileName);// this is the full path including folder and the filename
		// save the file in the folder
		Files.copy(file.getInputStream(),fullFilePath,StandardCopyOption.REPLACE_EXISTING);
		Tender tender=new Tender();
		tender.setFileName(file.getOriginalFilename());
		tender.setFilePath(fullFilePath.toString());
		return tr.save(tender);
		
	}
	
	// get all the tender from the database
	public List<Tender> getAllTender() {
		return tr.findAll();
	}
	
	public Tender getTenderById(Long id) {
		return tr.findById(id).orElseThrow(()->new RuntimeException("this is file not found in the folder"+id));
	}

}
