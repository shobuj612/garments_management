package com.sunshine.sunspring.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshine.sunspring.model.MerchandisingInfo;
import com.sunshine.sunspring.repository.MarchendisingRepository;

@Service
public class MarchendisingService {

	// this is the DI injection
	
	@Autowired
	
	private MarchendisingRepository mr;
	
	// this is the method to collect all the merchandising information
	public List<MerchandisingInfo> getAllMarchendisingInfo(){
		return mr.findAll();
		
	}
	
	
	// this is the method to update the merchandising by the id and the put some merchandising
	

	public MerchandisingInfo updateMarchendising( Long id,MerchandisingInfo mar) {
		
		mar.setMerch_id(id);
		
		return mr.save(mar);
	}
	
	
	// this is the method to insert something to the database
	
	public MerchandisingInfo postMarchendising(MerchandisingInfo mar) {
		
		return mr.save(mar);
	}
	
	// this is the method to delete the merchandising by the id
	
	public void deleteMarchendising( Long id) {
		
		mr.deleteById(id);
	}
	

}
