package com.sunshine.sunspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sunshine.sunspring.model.Buyer;
import com.sunshine.sunspring.service.BuyerService;

@RestController
@RequestMapping("/buyer")
@CrossOrigin(origins = "http://localhost:4200")
public class BuyerController {

    @Autowired
    private BuyerService bs;

    // Get all buyers
    @GetMapping
    public ResponseEntity<List<Buyer>> getAllBuyerByService() {
        List<Buyer> buyers=bs.getAllBuyer();
        return  ResponseEntity.ok(buyers);
    }

    // Update buyer by ID
    @PutMapping("/{id}")
    public ResponseEntity<Buyer> updateBuyerByService(@PathVariable Long id, @RequestBody Buyer buyer) {
        // Ensure the ID is set for update
        Buyer myBuyer=bs.updateBuyer(id, buyer);
        
        return ResponseEntity.ok(myBuyer);
    }

    // Insert new buyer (ID generated automatically in model)
    @PostMapping
    public ResponseEntity<Buyer> postBuyerByService(@RequestBody Buyer buyer) {
        	Buyer hiBuyer=bs.postBuyer(buyer);
        	 return ResponseEntity.ok(hiBuyer);
    }

    // Delete buyer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyerByService(@PathVariable Long id) {
        bs.deleteBuyer(id);
        return ResponseEntity.noContent().build();
    }
    // this is the method to get the last data from the database
    @GetMapping("/last")
    public ResponseEntity<Buyer> getLastBuyerByController(){
    	return ResponseEntity.ok(bs.getLastBuyerByService());
    }
}
