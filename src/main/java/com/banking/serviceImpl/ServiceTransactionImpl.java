package com.banking.serviceImpl;

import com.banking.dao.Transaction;
import com.banking.daoImpl.TransationImpl;
import com.banking.service.Service;
import com.banking.service.ServiceTransaction;
import com.banking.ui.Customer;
import com.banking.ui.TransationPojo;

public class ServiceTransactionImpl implements ServiceTransaction {

  Transaction t = new TransationImpl();

	public void deposit(Customer customer) {
		// TODO Auto-generated method stub
		
		
		
	}

	public void withDraw(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void showBalance(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void fundTransfer() {
		// TODO Auto-generated method stub
		
	}

}
