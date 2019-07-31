package com.risk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.risk.dao.EmployeeDao;
import com.risk.model.Employee;



@Service("UserService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
		
	}

	
	

}
