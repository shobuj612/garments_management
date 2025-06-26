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
import com.sunshine.sunspring.model.Shipping;
import com.sunshine.sunspring.service.ShippingService;
@RestController
@RequestMapping("/ship")
@CrossOrigin(origins="http://localhost:4200")
public class ShippingController {
	// this is the DI injection
	@Autowired
	private ShippingService sr;
	
	@GetMapping
	public ResponseEntity<List<Shipping>> getAllShipping(){
		List<Shipping> ship=sr.getAllShipping();
		return new ResponseEntity<>(ship,HttpStatus.OK);
	}
	
	// this is the method to update something in the database
	@PutMapping("/{id}")
	public ResponseEntity<Shipping> updateShipping(@PathVariable Long id , @RequestBody Shipping ship) {
		Shipping shipping =sr.updateShipping(id, ship);
		return new ResponseEntity<>(shipping,HttpStatus.ACCEPTED);
	}

	  // this is the method to post something in the database
	
	@PostMapping
	public ResponseEntity<Shipping> postShipping(@RequestBody Shipping ship) {
		Shipping shipping=sr.postShipping(ship);
	return	new ResponseEntity<>(shipping,HttpStatus.CREATED);
	
	}
	
	// this is the method to deletesomething from the database
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteShipping(@PathVariable Long id) {
		sr.deleteShipping(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	// this is the method to find the last data from the database
	@GetMapping("/last")
	public ResponseEntity<Shipping> getLastShippingByController(){
		return ResponseEntity.ok(sr.getLastShippingByService());
	}
}
