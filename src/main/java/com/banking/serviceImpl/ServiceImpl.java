package com.banking.serviceImpl;

import com.banking.dao.Welcome;
import com.banking.daoImpl.WelcomeImpl;
import com.banking.service.Service;
import com.banking.ui.Customer;

public class ServiceImpl implements Service {
  Welcome w = new WelcomeImpl();
  Customer customer = new Customer();
	
	
	
	public Customer login(Customer customer) {
		return w.login(customer);
		
		
	}

	public boolean isAadharNoCorrect(Object aadharNo) {
		// TODO Auto-generated method stub
		if(((String) aadharNo).length() == 12)
			return true;
		else
			return false;
	}

	public boolean isMobileNoCorrect(String mobileNo) {
		// TODO Auto-generated method stub
		if(mobileNo.length() == 10)
			return true;
		else
			return false;
	}

	public int registration(Customer customer) {
		int accNo = w.registration(customer);
		if(accNo==-1)
			return accNo;
		else
		return -1;
	}

	
}
