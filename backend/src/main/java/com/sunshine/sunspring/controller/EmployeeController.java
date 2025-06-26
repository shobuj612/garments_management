package com.sunshine.sunspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sunshine.sunspring.model.*;
import com.sunshine.sunspring.repository.*;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeController {
	private EmployeeRepository er;

	public EmployeeController(EmployeeRepository er) {
		this.er = er;
	}
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> list=er.findAll();
		if(list != null) {
			return ResponseEntity.ok().body(list);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@PostMapping("/post")
	public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee){
		if(employee !=null) {
			return ResponseEntity.ok(er.save(employee));
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}

}
