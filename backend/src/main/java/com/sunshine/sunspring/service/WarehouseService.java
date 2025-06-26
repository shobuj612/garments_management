package com.sunshine.sunspring.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshine.sunspring.model.Warehouse;
import com.sunshine.sunspring.repository.WarehouseRepository;

@Service
public class WarehouseService {


	// this is the DI injection
	
	
	@Autowired
	
	private WarehouseRepository wr;
	
	// this is the method to get all the data from the database

	public List<Warehouse> getAllWarehouse(){
		
	  return wr.findAll();
	}
	
	// this is the method to upadate data in the database

	
	public Warehouse updateWarehouse(Long id , Warehouse ware) {
		
		ware.setWarehouse_id(id);
		
		return wr.save(ware);
		
	}
	
	// this is the method to post something in the database
	
	
	
	
	
	public Warehouse postWarehouse(Warehouse war) {
		
		return wr.save(war);
	}

	 // this is the method to delete something from the database
	
	public void deleteWarehouse(Long id) {
		
		wr.deleteById(id);
	}
	
	// this is the method to find the last datafrom the database
	public Warehouse getLastWarehouseByService() {
		return wr.findLastWareHouse()
;	}
}
