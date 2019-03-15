package com.banking.dao;

import com.banking.ui.Customer;
import com.banking.ui.TransationPojo;

public interface Transaction {
      Customer deposit(Customer customer);
      Customer withDraw(Customer customer);
      Customer showBalance(Customer customer);
      int  fundTransfer(long fromAccountNo,long toAccountNo,long balance,long amount);
}
