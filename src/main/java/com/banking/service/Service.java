package com.banking.service;

import com.banking.ui.Customer;

public interface Service {
	public  int registration(Customer customer);
     Customer login( Customer customer);
     boolean isAadharNoCorrect(Object object);
 	boolean isMobileNoCorrect(String mobileNo);
	
}
