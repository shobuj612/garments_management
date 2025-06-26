package com.sunshine.sunspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunshine.sunspring.model.*;

public interface EmployeeRepository  extends JpaRepository<Employee,Long>{
	Optional<Employee> findByEmployeeId(String employeeId);

}
