package com.banking.dao;

import com.banking.ui.Customer;

public interface Transaction {
      void deposit(Customer customer);
      void withDraw(Customer customer);
      void showBalance(Customer customer);
      void fundTransfer(Customer customer);
}
