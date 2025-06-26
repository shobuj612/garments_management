package com.sunshine.sunspring.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.sunshine.sunspring.model.Finishing;
import com.sunshine.sunspring.service.FinishingService;
@RestController
@RequestMapping("/finis")
@CrossOrigin(origins= "http://localhost:4200")
public class FinishingController {
	// this is  the DI injection
	@Autowired
	private FinishingService fr;
	
	@GetMapping
	public ResponseEntity<List<Finishing>> getAllFinishing(){
		List<Finishing> finish=fr.getAllFinishing();
		return new ResponseEntity<>(finish,HttpStatus.OK);
	}
	
	// this is the method to update the finishing data
	@PutMapping("/{id}")
	public ResponseEntity<Finishing> updateFinishing(@PathVariable Long id , @RequestBody Finishing fin) {
		Finishing finish=fr.updateFinishing(id, fin);
		return new ResponseEntity<>(finish,HttpStatus.ACCEPTED);
	}
	
	// this is the method to post in the database
	
	@PostMapping
	public ResponseEntity<Finishing> postFininshig(@RequestBody Finishing fin) {
		Finishing finish=fr.postFininshig(fin);
		return new ResponseEntity<>(finish,HttpStatus.CREATED);
	}
	// this is the method to delete the data from  the database
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFinishing(@PathVariable Long id) {
		fr.deleteFinishing(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
   // this is the method to find the last data from the database
	@GetMapping("/last")
	public ResponseEntity<Finishing> getLastFinishingByController(){
		return ResponseEntity.ok(fr.getLastFinishingByService());
	}
}
