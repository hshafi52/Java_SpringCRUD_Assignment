package com.uxpsystems.assignment.service;

import java.util.List;

import com.uxpsystems.assignment.model.Employee;

public interface EmployeeService {

	Employee findById(int id);

	void saveEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	void deleteEmployee(int id);

	

}
