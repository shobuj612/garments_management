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
import com.sunshine.sunspring.model.Sewing;
import com.sunshine.sunspring.service.SewingService;
@RestController
@RequestMapping("/sew")
@CrossOrigin(origins = "http://localhost:4200")
public class SewingController {
	// this is the DI injection
	@Autowired
	private SewingService sr;
	// this is the method to get all the sewing information 
	@GetMapping
	public ResponseEntity<List<Sewing>> getAllSewing(){
		List<Sewing> sew=sr.getAllSewing();
		return ResponseEntity.status(HttpStatus.OK).body(sew);
	}
            
	  // this is the method to update by id and put sewing information in the database
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Sewing> updateSewing(@PathVariable Long id , @RequestBody Sewing sew) {
		Sewing sewing=sr.updateSewing(id, sew);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(sewing);
	}
	
	
	// this is the method to post in the database
	@PostMapping
	public ResponseEntity<Sewing> postSewing(@RequestBody Sewing sew) {
		Sewing sewing=sr.postSewing(sew);
		return ResponseEntity.status(HttpStatus.CREATED).body(sewing);
	}
	
	 // this is the method to delete the sewing in the database
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSewing(@PathVariable Long id) {
		sr.deleteSewing(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	// this is the method to find the last data from the database
	@GetMapping("/last")
	public ResponseEntity<Sewing> getLastSewingByController(){
		return ResponseEntity.ok(sr.getLastSewingByService());
	}
}
