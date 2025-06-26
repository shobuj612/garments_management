package com.sunshine.sunspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunshine.sunspring.model.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse,Long> {
@Query(value="SELECT * FROM warehouse ORDER BY warehouse_id DESC LIMIT 1",nativeQuery=true)
Warehouse findLastWareHouse();
}
