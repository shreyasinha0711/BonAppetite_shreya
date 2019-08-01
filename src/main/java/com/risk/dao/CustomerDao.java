package com.risk.dao;

import java.util.List;

import com.risk.model.Customer;

public interface CustomerDao {
	
	void saveCustomer(Customer customer);
	
	Customer findCustomerByPhone(String phone);

}
