package com.banking.service;

import com.banking.ui.Customer;

public interface ServiceTransaction {
	void deposit(Customer customer);
    void withDraw(Customer customer);
    void showBalance(Customer customer);
    void fundTransfer();
}
