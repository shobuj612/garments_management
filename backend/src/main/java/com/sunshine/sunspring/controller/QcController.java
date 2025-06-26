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
import com.sunshine.sunspring.model.QC;
import com.sunshine.sunspring.service.QcService;

@RestController
@RequestMapping("/qc")
@CrossOrigin(origins="http://localhost:4200")
public class QcController {
	
	// this is the DI injection
	
	
	@Autowired
	private QcService qr;
	
	// this is  the method to find the all data from the database
	
	
	@GetMapping
	public ResponseEntity<List<QC>> getAllQc(){
		List<QC> qc=qr.getAllQc();
		return new ResponseEntity<>(qc,HttpStatus.OK);
	}
	
	
	// this is the method to update the database 
	
	@PutMapping("/{id}")
	public ResponseEntity<QC> updateQC(@PathVariable Long id, @RequestBody QC qc) {
		QC quality=qr.updateQC(id, qc);
		return new ResponseEntity<>(quality,HttpStatus.ACCEPTED);
	}
	
	
	// this is the method to post something in the database
	@PostMapping
	public ResponseEntity<QC> postQc(@RequestBody QC qc) {
		QC quality=qr.postQc(qc);
		return new ResponseEntity<>(quality,HttpStatus.CREATED);
		
	}
	
	
	// this is the method to delete the data from the database
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteQc(@PathVariable Long id) {
		qr.deleteQc(id);
		return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	//this is the method to find the last data from the database
	@GetMapping("/last")
	public ResponseEntity<QC> getLastQcByController(){
		return ResponseEntity.ok(qr.getLastQcByService());
	}

}
