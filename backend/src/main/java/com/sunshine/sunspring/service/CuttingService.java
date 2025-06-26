package com.sunshine.sunspring.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshine.sunspring.model.Cutting;
import com.sunshine.sunspring.repository.CuttingRepository;
@Service
public class CuttingService {

	@Autowired
	
	private CuttingRepository cr;
	
	// this is the method to get all the Cutting information
	
    public List<Cutting> getAllCutting(){
		
		return cr.findAll();
		
	}
	
	  // this is the method to update the Cutting in the database
	
	
	public Cutting updateCutting(Long id , Cutting cut) {
		
		cut.setCutting_id(id);
		
	    return	cr.save(cut);

	}
	
	
	// this is the method to insert the cutting information in the dataase
	
	
	
	public Cutting postCutting(Cutting cut) {
		return cr.save(cut);
		
	}
	
	
	// this is the method to delete the cutting information in the database
	
	
	public void deleteCutting(Long id) {
		cr.deleteById(id);
	}
   // this is the method to find the last data from the table
	public Cutting getLastCuttingByService() {
		return cr.findLastCutting();
	}
}
