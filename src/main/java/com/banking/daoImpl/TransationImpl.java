package com.banking.daoImpl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.banking.dao.Transaction;
import com.banking.ui.Customer;
import com.banking.ui.TransationPojo;

public class TransationImpl  implements Transaction{
Customer c = new Customer();
TransationPojo tr = new TransationPojo();
	

	public void deposit(Customer customer) {
		// TODO Auto-generated method stub
		double bal = customerDetails.getBalance();
		bal += customerDetails.getAmount();
		try {
			
		
			PreparedStatement stmt = connection
					.prepareStatement("update customer_details set balance = ? where account_no = ?");
			stmt.setInt(2, customerDetails.getAccountNo());
			stmt.setInt(1, (int) bal);
			stmt.executeUpdate();
			customerDetails.setBalance(bal);
		
		
		
	}

	public void withDraw(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void showBalance(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void fundTransfer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

}
