package com.banking.daoImpl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import com.banking.dao.Welcome;
import com.banking.ui.Customer;

public class WelcomeImpl implements Welcome {
 Scanner sc =new Scanner(System.in);
 Customer customer = new Customer();
	public Customer registration() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "CAPGEMINI", "oracle123");
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into customer_details(acount_no,first_name,last_name,email_id,password,pancard_no,aadhar_no,address,mobile_no,balance) values(account_sequence.nextval,?,?,?,?,?,?,?,?,0)");
			
			
			
			
			preparedStatement.setString(1, customer.getFirstname());
			preparedStatement.setString(2, customer.getLastname());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.setString(5, customer.getPanNo());
			preparedStatement.setString(6,customer.getAadharCardNo());
			preparedStatement.setString(7, customer.getAddress());
			preparedStatement.setLong(8,customer.getMobileNo());
			
			
			int i = preparedStatement.executeUpdate();
			
			if(i==1) {
				System.out.println("done");
			}
			else
				System.out.println("error");
			
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
		
	}

	public Customer login(Customer customer) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "CAPGEMINI", "oracle123");
			
			Statement st =  (Statement) connection.createStatement();
			 ResultSet rs = ((java.sql.Statement) st).executeQuery("select account_no from customer_details");
			 
			 while(rs.next()) {
				 if(rs.getLong(1)==customer.getAccountNo()&& rs.getString(5)==customer.getPassword()) {
					 long user = customer.getAccountNo();
				 }
					 
				
			 }
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Customer user = null;
		return user;
		
		
		
	}

}
