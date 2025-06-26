package com.sunshine.sunspring.service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sunshine.sunspring.model.Notice;
import com.sunshine.sunspring.repository.NoticeRepository;
@Service
public class NoticeService {
	
    @Value("${file.upload-dir}")
    
    private String uploadDir;

    private final NoticeRepository repository;

    public NoticeService(NoticeRepository repository) {
        this.repository = repository;
    }

    public Notice saveFile(MultipartFile file) throws IOException {
        // Ensure the upload directory exists — create it if it doesn't
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Generate a unique file name to avoid collisions
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);

        // Save the file to the folder
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Save file metadata to the database
        Notice meta = new Notice();
        meta.setFileName(file.getOriginalFilename());
        meta.setFilePath(filePath.toString());

        return repository.save(meta);
    }

    public List<Notice> getAllFiles() {
        return repository.findAll();
    }
    
    public Notice getFileById(Long id) {
    	return repository.findById(id).orElseThrow(()-> new RuntimeException("file not found with this id"+id));
    }

}
