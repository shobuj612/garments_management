package com.sunshine.sunspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunshine.sunspring.model.FabricInfo;

public interface FabricRepository extends JpaRepository<FabricInfo, Long> {
@Query(value="SELECT * FROM fabric_info ORDER BY fabric_id DESC LIMIT 1",nativeQuery=true)
FabricInfo findLastFabric();
}
