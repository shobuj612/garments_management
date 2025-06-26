package com.sunshine.sunspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshine.sunspring.model.Buyer;
import com.sunshine.sunspring.repository.BuyerRepository;

@Service
public class BuyerService {
	
	  @Autowired
	    private BuyerRepository br;

	    // Get all buyers
	   
	    public List<Buyer> getAllBuyer() {
	        return br.findAll();
	    }

	    // Update buyer by ID
	  
	    public Buyer updateBuyer( Long id, Buyer buyer) {
	        buyer.setBuyerId(id); // Ensure the ID is set for update
	        return br.save(buyer);
	    }

	    // Insert new buyer (ID generated automatically in model)
	   
	    public Buyer postBuyer(Buyer buyer) {
	        return br.save(buyer);
	    }

	    // Delete buyer by ID
	   
	    public void deleteBuyer(Long id) {
	        br.deleteById(id);
	    }
     // find the last Buyer information
	    
	    public Buyer getLastBuyerByService() {
	    	return br.findTopByOrderByBuyerIdDesc();
	    }
}
