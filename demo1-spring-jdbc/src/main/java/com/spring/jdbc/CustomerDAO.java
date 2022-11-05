package com.spring.jdbc;

import java.util.List;

public interface CustomerDAO {

	public void addCustomer(Customer cus);
	public List<Customer> getAllCustomers();
	public List<Customer> getCustomerByCity(String city);
}
