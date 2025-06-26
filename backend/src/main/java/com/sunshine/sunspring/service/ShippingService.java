package com.sunshine.sunspring.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshine.sunspring.model.Shipping;
import com.sunshine.sunspring.repository.ShippingRepository;

@Service
public class ShippingService {

	// this is the DI injection
	@Autowired
	private ShippingRepository sr;
	
	public List<Shipping> getAllShipping(){
		
		return sr.findAll();
	}
	// this is the method to update something in the database
	
	public Shipping updateShipping(Long id , Shipping ship) {
		
		ship.setShipping_id(id);
		
		return sr.save(ship);
	}

	  // this is the method to post something in the database
	
	
	
	public Shipping postShipping(Shipping ship) {
		
	return	sr.save(ship);
	
	}
	
	// this is the method to deletesomething from the database
	
	public void deleteShipping(Long id) {
		
		sr.deleteById(id);
	}
	
	// this is the method to find the data from the database
	public Shipping getLastShippingByService() {
		return sr.findLastShipping();
	}
}
