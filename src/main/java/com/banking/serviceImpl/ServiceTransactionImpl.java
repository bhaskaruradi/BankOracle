package com.banking.serviceImpl;

import com.banking.dao.Transaction;
import com.banking.daoImpl.TransationImpl;
import com.banking.service.Service;
import com.banking.service.ServiceTransaction;
import com.banking.ui.Customer;
import com.banking.ui.TransationPojo;

public class ServiceTransactionImpl implements ServiceTransaction {

  Transaction t = new TransationImpl();

	Customer cd = new Customer();

	public Customer deposit(Customer customer) {
		// TODO Auto-generated method stub
		return t.deposit(customer);
	}

	public Customer withDraw(Customer customer) {
		// TODO Auto-generated method stub
		return t.withDraw(customer);
	}

	public Customer showBalance(Customer customer) {
		// TODO Auto-generated method stub
		return t.showBalance(customer);
	}

	public int fundTransfer(long fromAccountNo,long toAccountNo,long balance,long amount) {
		// TODO Auto-generated method stub
		return t.fundTransfer(fromAccountNo,toAccountNo,balance,amount);
	}



	

}
