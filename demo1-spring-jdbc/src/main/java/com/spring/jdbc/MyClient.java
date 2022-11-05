package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyClient {
	
	public static void main(String[] args) {
	
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		CustomerDAO custDAO = (CustomerDAO)ctx.getBean("custDAO");
		List<Customer> customers = custDAO.getAllCustomers();
		//customers.forEach(myCust -> System.out.println(myCust.getCname()));
		
		
		List<Customer> customersByCity = custDAO.getCustomerByCity("bangalore");
		//customersByCity.forEach(myCust -> System.out.println(myCust.getCname()));
		
		Customer cust = new Customer(6, "Harish", "haris@gmail.com", 12334, "hydrabad");
		custDAO.addCustomer(cust);
		
		
	}

}
