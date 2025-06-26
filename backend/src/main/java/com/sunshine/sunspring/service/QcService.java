package com.sunshine.sunspring.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshine.sunspring.model.QC;
import com.sunshine.sunspring.repository.QcRepository;

@Service
public class QcService {

	// this is the DI injection
	
	
	@Autowired
	
	private QcRepository qr;
	
	// this is  the method to find the all data from the database
	
	public List<QC> getAllQc(){
		
		return qr.findAll();
	}
	
	// this is the method to update the database 
	
	public QC updateQC(Long id,QC qc) {
		
		qc.setQc_id(id);
		
		return qr.save(qc);
		
	}
	
	// this is the method to post something in the database
	
	public QC postQc( QC qc) {
		
		return qr.save(qc);
	}
	
	
	// this is the method to delete the data from the database
	
	public void deleteQc(Long id) {
		
		qr.deleteById(id);
	}
   // this is the method to find the last data from the database
	public QC getLastQcByService() {
		return qr.findLastQc();
	}

}
