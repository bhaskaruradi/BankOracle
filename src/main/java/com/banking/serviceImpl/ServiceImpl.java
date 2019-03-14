package com.banking.serviceImpl;

import com.banking.dao.Welcome;
import com.banking.daoImpl.WelcomeImpl;
import com.banking.service.Service;
import com.banking.ui.Customer;

public class ServiceImpl implements Service {
  Welcome w = new WelcomeImpl();
  Customer customer = new Customer();
	
	public Customer registration() {
		
		
		return w.registration();
		// TODO Auto-generated method stub
		
	}
	
	public Customer login(Customer customer) {
		return w.login(customer);
		// TODO Auto-generated method stub
		
	}

	public void validateAdhar() {
		// TODO Auto-generated method stub
		
		
	}

	
}
