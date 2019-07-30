package com.risk.dao;

import org.springframework.stereotype.Repository;

import com.risk.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {


	@Override
	public void saveCustomer(Customer customer) {
		persist(customer);
	}


}