package com.sunshine.sunspring.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunshine.sunspring.model.*;


public interface AttendenceRepository extends JpaRepository<Attendence, Long>{
 boolean existsByEmployeeAndDate(Employee employee,LocalDate date);
}