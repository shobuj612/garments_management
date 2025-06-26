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
import com.sunshine.sunspring.model.FabricInfo;
import com.sunshine.sunspring.service.FabricService;
@RestController
@RequestMapping("/fabric")
@CrossOrigin(origins = "http://localhost:4200")
public class FabricController {
	
	// this is the DI injection in the controller
	
	
	@Autowired
	
	private FabricService fr;
	
	// this is the method to get all the fabric 
	
	@GetMapping
	public ResponseEntity<List<FabricInfo>> getAllFabric(){
		List<FabricInfo> fab=fr.getAllFabric();
		return ResponseEntity.ok().body(fab);
		
	}

	  // this is the method to update design information
	
	@PutMapping("/{id}")
	public ResponseEntity< FabricInfo> updateFabric(@PathVariable Long id , @RequestBody FabricInfo fabric) {
		 FabricInfo fab=fr.updateFabric(id, fabric);
		return ResponseEntity.ok().body(fab);
		
	}
	
	
	// this is the method to postFabric in the database
	
	
	@PostMapping
	public ResponseEntity<FabricInfo> postFabric(@RequestBody FabricInfo fab) {
		FabricInfo fabric=fr.postFabric(fab);
		return ResponseEntity.ok().body(fabric);
			
	}
	
	
	// this is the method to delete the Fabric from the database
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFabric(@PathVariable Long id) {
		fr.deleteFabr(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/last")
	public ResponseEntity<FabricInfo> getLastFabricByService(){
		return ResponseEntity.ok(fr.getLastFabricByService());
	}
	
	
}
