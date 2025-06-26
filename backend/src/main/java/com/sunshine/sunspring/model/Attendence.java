package com.sunshine.sunspring.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="attendence")
public class Attendence {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="employee_id",referencedColumnName="employeeId")
     private Employee employee;
	private LocalDate date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
