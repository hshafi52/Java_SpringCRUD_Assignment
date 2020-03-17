package com.uxpsystems.assignment.dao;

import java.util.List;

import com.uxpsystems.assignment.model.Employee;

public interface EmployeeDao {

	Employee findById(int id);

	void saveEmployee(Employee employee);
	
	void deleteEmployee(String ssn);
	
	

	public Employee updateEmployee(Employee employee);
	

}
