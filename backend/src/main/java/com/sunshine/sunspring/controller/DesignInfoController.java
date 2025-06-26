package com.sunshine.sunspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.sunspring.model.DesignInfo;
import com.sunshine.sunspring.repository.DesignInfoRepository;
import com.sunshine.sunspring.service.DesignService;

@RestController
@RequestMapping("/design")
@CrossOrigin(origins = "http://localhost:4200")

public class DesignInfoController {
	
	
	// this the DI injection 
	
	@Autowired
	private DesignService dr;
	
 // this is the method to getAll the design
	
	@GetMapping
	public ResponseEntity<List<DesignInfo>> getAllDesing(){
		List<DesignInfo> design=dr.getAllDesing();
		return ResponseEntity.ok().body(design);
	}
	
	// this is the method to get the last row from the database
	@GetMapping("/last")
	public ResponseEntity<DesignInfo> lastData(){
		return ResponseEntity.ok(dr.lastDataByService());
	}
	
	// this is the method to update the design information
	
	
	@PutMapping("/{id}")
	public ResponseEntity<DesignInfo> updateDesign(@PathVariable Long id, @RequestBody DesignInfo dn) {
		DesignInfo dd=dr.updateDesign(id, dn);
		return ResponseEntity.status(HttpStatus.CREATED).body(dd);
	
	}
	
	
	// this is the method to postdesing in the database
	
	
	@PostMapping
	public ResponseEntity<DesignInfo> postDesign(@RequestBody DesignInfo dn) {
		DesignInfo dign=dr.postDesign(dn);
		return ResponseEntity.status(HttpStatus.CREATED).body(dign);
	}
	
	
	
	// this is the method to delete the design
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDesign(@PathVariable Long id) {
		
		dr.deleteDesign(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
