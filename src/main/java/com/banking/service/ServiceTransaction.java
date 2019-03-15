package com.banking.service;

import com.banking.ui.Customer;
import com.banking.ui.TransationPojo;

public interface ServiceTransaction {
	Customer deposit(Customer customer);
    Customer withDraw(Customer customer);
    Customer showBalance(Customer customer);
   int fundTransfer(long fromAccountNo,long toAccountNo,long balance,long amount);

	
}
