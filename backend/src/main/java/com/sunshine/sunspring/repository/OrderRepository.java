package com.sunshine.sunspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunshine.sunspring.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
@Query(value="SELECT * FROM orders ORDER BY order_id DESC LIMIT 1",nativeQuery=true)
Order findLastOrder();
}
