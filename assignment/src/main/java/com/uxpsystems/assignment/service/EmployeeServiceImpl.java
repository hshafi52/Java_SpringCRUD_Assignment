package com.uxpsystems.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uxpsystems.assignment.dao.EmployeeDao;
import com.uxpsystems.assignment.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public Employee findById(int id) {
		return dao.findById(id);
	}

	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with proper
	 * values within transaction. It will be updated in db once transaction ends.
	 */
	/*public void updateEmployee(Employee employee) {
		System.out.println("inside updateEmployee---------");
		Employee entity = dao.findById(employee.getId());
		System.out.println("entity value---------"+entity);
		if (entity != null) {
			entity.setName(employee.getName());
			entity.setAmount(employee.getAmount());
			System.out.println("Name"+employee.getName());
		}
	}*/
	public Employee updateEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return dao.updateEmployee(employee);
    }

	public void deleteEmployee(int id) {
		dao.deleteEmployee(id);
	}

	

}
