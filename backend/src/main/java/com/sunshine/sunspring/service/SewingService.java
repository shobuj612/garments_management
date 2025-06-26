package com.sunshine.sunspring.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshine.sunspring.model.Sewing;
import com.sunshine.sunspring.repository.SewingRepository;

@Service
public class SewingService {

	// this is the DI injection
	@Autowired
	private SewingRepository sr;
	
	// this is the method to get all the sewing information 
	
	
	public List<Sewing> getAllSewing(){
		return sr.findAll();
	}
            
	  // this is the method to update by id and put sewing information in the database
	
	public Sewing updateSewing(Long id ,Sewing sew) {
		sew.setSewing_id(id);
		return sr.save(sew);
	}
	
	// this is the method to post in the database

	public Sewing postSewing(Sewing sew) {
		
		return sr.save(sew);
		
	}
	
	 // this is the method to delete the sewing in the database
	
	public void deleteSewing(Long id) {
		
		sr.deleteById(id);
	}
	// this is the method to find the last data from the database
	
	public Sewing getLastSewingByService() {
		return sr.findLastSewing();
	}
}
