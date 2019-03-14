package com.banking.service;

import com.banking.ui.Customer;

public interface Service {
	 Customer registration();
     Customer login( Customer customer);
	void validateAdhar();
}
