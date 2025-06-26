package com.sunshine.sunspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunshine.sunspring.model.Finishing;

public interface FinishingRepository extends JpaRepository<Finishing, Long> {
@Query(value="SELECT * FROM finishing ORDER BY finish_id DESC LIMIT 1",nativeQuery=true)
Finishing findLastFinishing();
}
