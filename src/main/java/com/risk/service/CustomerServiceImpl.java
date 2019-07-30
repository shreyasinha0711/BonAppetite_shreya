package com.risk.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.dao.CustomerDao;
import com.risk.model.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	@Autowired
    private CustomerDao customerDao;
	
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
		
	}
}