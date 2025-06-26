package com.sunshine.sunspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.sunshine.sunspring.model.Cutting;
import com.sunshine.sunspring.repository.CuttingRepository;
import com.sunshine.sunspring.service.CuttingService;

@RestController
@RequestMapping("/cut")
@CrossOrigin(origins = "http://localhost:4200")
public class CuttingController {

	// this is the DI injection in the controller
	
	
	@Autowired
	
	private CuttingService cr;
	
	// this is the method to get all the Cutting information
	
	
	@GetMapping
    public ResponseEntity<List<Cutting>> getAllCuttingByService(){
		List<Cutting> cuttings=cr.getAllCutting();
		return ResponseEntity.ok(cuttings);	
	}
	
	  // this is the method to update the Cutting in the database
	
	@PutMapping("/{id}")
	public ResponseEntity<Cutting> updateCutting(@PathVariable Long id , @RequestBody Cutting cut) {
	Cutting ccut=cr.updateCutting(id, cut);
	return ResponseEntity.ok(ccut);
	
	}
	
	
	// this is the method to insert the cutting information in the dataase
	
	@PostMapping
	public ResponseEntity<Cutting> postCutting(@RequestBody Cutting cut) {
		Cutting hiCut=cr.postCutting(cut);
		return ResponseEntity.ok(hiCut);
	}
	
	// this is the method to delete the cutting information in the database
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCutting(@PathVariable Long id) {
		cr.deleteCutting(id);
		return ResponseEntity.noContent().build();
		
	}
	// this is the method to find the last datafrom the database
	@GetMapping("/last")
	public ResponseEntity<Cutting> getLastCuttingByController(){
		return ResponseEntity.ok(cr.getLastCuttingByService());
	}
	
      }
