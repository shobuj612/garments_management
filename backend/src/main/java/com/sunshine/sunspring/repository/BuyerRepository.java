package com.sunshine.sunspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunshine.sunspring.model.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Long>{
	// this is custom quwry for the camel case
	Buyer findTopByOrderByBuyerIdDesc();
	
	

}
