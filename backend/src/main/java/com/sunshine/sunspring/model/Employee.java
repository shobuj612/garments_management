package com.sunshine.sunspring.model;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(unique=true)
private String employeeId;
private String employeeName;
private String department;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employId) {
	this.employeeId = employId;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}

}