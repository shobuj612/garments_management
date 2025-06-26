package com.sunshine.sunspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunshine.sunspring.model.DesignInfo;

public interface DesignInfoRepository  extends JpaRepository<DesignInfo, Long> {
	//DesignInfo findTopByOrderByDesign_idDesc();
	@Query(value = "SELECT * FROM design_info ORDER BY design_id DESC LIMIT 1", nativeQuery = true)
	DesignInfo findLastDesign();



}
