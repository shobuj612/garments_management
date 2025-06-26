package com.sunshine.sunspring.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshine.sunspring.model.FabricInfo;
import com.sunshine.sunspring.repository.FabricRepository;
@Service
public class FabricService {

	
	@Autowired
	
	private FabricRepository fr;
	
	// this is the method to get all the fabric 
	
	public List<FabricInfo> getAllFabric(){
		
		return fr.findAll();
		
	}

	  // this is the method to update design information
	
	public FabricInfo updateFabric(Long id , FabricInfo fabric) {
		fabric.setFabric_id(id);
		return fr.save(fabric);
		
	}
	
	// this is the method to postFabric in the database
	public FabricInfo postFabric(FabricInfo fab) {
		
		return fr.save(fab);
			
	}
	
	
	// this is the method to delete the Fabric from the database

	public void deleteFabr(Long id) {
		
		fr.deleteById(id);
	}
	
	// this is the method to find the last fabric
	public FabricInfo getLastFabricByService() {
		return fr.findLastFabric();
	}

}
