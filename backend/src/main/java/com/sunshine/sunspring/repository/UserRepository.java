package com.sunshine.sunspring.repository;

import com.sunshine.sunspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}