package com.sunshine.sunspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunshine.sunspring.model.Cutting;

public interface CuttingRepository extends JpaRepository<Cutting, Long> {
@Query(value="SELECT * FROM cutting ORDER BY cutting_id DESC LIMIT 1",nativeQuery=true)
Cutting findLastCutting();
}
