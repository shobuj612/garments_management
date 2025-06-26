package com.sunshine.sunspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunshine.sunspring.model.Shipping;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {
@Query(value="SELECT * FROM shipping ORDER BY shipping_id DESC LIMIT 1",nativeQuery=true)
Shipping findLastShipping();
}
