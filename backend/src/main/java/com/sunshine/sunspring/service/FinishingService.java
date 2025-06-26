package com.sunshine.sunspring.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshine.sunspring.model.Finishing;
import com.sunshine.sunspring.repository.FinishingRepository;
@Service
public class FinishingService {

	@Autowired
	
	private FinishingRepository fr;
	
	public List<Finishing> getAllFinishing(){
		
		return fr.findAll();
	}
	
	// this is the method to update the finishing data
	
	public Finishing updateFinishing(Long id ,Finishing fin) {
		fin.setFinish_id(id);
		return fr.save(fin);
		
	}
	
	// this is the method to post in the database
	
	public Finishing postFininshig(Finishing fin) {
		
		return fr.save(fin);
	}
	
	
	// this is the method to delete the data from  the database
	
	
	public void deleteFinishing(Long id) {
		
		fr.deleteById(id);
	}

   // this is  the method to find the last data from the database
	public Finishing getLastFinishingByService() {
		return fr.findLastFinishing();
	}
}
