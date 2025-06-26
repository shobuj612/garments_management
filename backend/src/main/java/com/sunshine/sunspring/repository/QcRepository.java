package com.sunshine.sunspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunshine.sunspring.model.QC;

public interface QcRepository extends JpaRepository<QC, Long> {
@Query(value="SELECT * FROM qc_info ORDER BY qc_id DESC LIMIT 1",nativeQuery=true)
QC findLastQc();
}
