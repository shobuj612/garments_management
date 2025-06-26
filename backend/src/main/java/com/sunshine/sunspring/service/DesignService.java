package com.sunshine.sunspring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshine.sunspring.model.DesignInfo;
import com.sunshine.sunspring.repository.DesignInfoRepository;

@Service
public class DesignService {

	// this the DI injection 
	@Autowired
	private DesignInfoRepository dr;
	
 // this is the method to getAll the design
	
	
	public List<DesignInfo> getAllDesing(){
		
		return dr.findAll();
	}
	
	//this is the method to find the last row from the database
	
	public DesignInfo lastDataByService() {
		return dr.findLastDesign();
	}
	
	// this is the method to update the design information
	
	public DesignInfo updateDesign( Long id, DesignInfo dn) {
		
		dn.setDesign_id(id);
		
		return dr.save(dn);
	}
	
	
	// this is the method to postdesing in the database
	

	
	public DesignInfo postDesign( DesignInfo dn) {
		
		return dr.save(dn);
	}
	
	
	
	// this is the method to delete the design
	
	public void deleteDesign(Long id) {
		
		dr.deleteById(id);
	}
	
	

}
