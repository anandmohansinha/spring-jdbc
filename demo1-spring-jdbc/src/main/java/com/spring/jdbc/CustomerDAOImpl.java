package com.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("custDAO")
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	JdbcTemplate jTemp;

	@Override
	public void addCustomer(Customer cus) {
		String SQL = "insert into mycustomers value(?,?,?,?,?)";
		jTemp.update(SQL, cus.getCid(), cus.getCname(), cus.getEmail(), cus.getPhone(), cus.getCity());
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		String SQL = "select * from mycustomers";
		List<Customer> myList = jTemp.query(SQL, new CustomerRowMapper());
		return myList;
	}

	@Override
	public List<Customer> getCustomerByCity(String city) {
		String SQL = "select * from mycustomers where city=?";
		List<Customer> myList = jTemp.query(SQL, new CustomerRowMapper(), city);
		return myList;
	}

}
