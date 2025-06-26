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
import com.sunshine.sunspring.model.Warehouse;
import com.sunshine.sunspring.service.WarehouseService;
@RestController
@RequestMapping("/war")
@CrossOrigin(origins="http://localhost:4200")
public class WarehouseController {
	// this is the DI injection
	@Autowired
	private WarehouseService wr;
	
	// this is the method to get all the data from the database
	@GetMapping
	public ResponseEntity<List<Warehouse>> getAllWarehouse(){
		List<Warehouse> war=wr.getAllWarehouse();
	  return ResponseEntity.status(HttpStatus.OK).body(war);
	}
	// this is the method to update data in the database
	@PutMapping("/{id}")
	public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id , @RequestBody Warehouse ware) {
		Warehouse war=wr.updateWarehouse(id, ware);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(war);
		
	}
	
	// this is the method to post something in the database
	@PostMapping
	public ResponseEntity<Warehouse> postWarehouse(@RequestBody Warehouse war) {
		Warehouse wa=wr.postWarehouse(war);
		return ResponseEntity.status(HttpStatus.CREATED).body(wa);
	}

	 // this is the method to delete something from the database
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
		wr.deleteWarehouse(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	// this is the method to find the last data from the database
	@GetMapping("/last")
	public ResponseEntity<Warehouse> getLastWarehouseByController(){
		return ResponseEntity.ok(wr.getLastWarehouseByService());
	}
}
