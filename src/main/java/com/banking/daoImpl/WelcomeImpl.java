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
	public int  registration(Customer customer) {
		// TODO Auto-generated method stub
		int accNo = 0,i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "CAPGEMINI", "oracle123");
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into customer_details(acount_no,first_name,last_name,email_id,password,pancard_no,aadhar_no,address,mobile_no) values(account_sequence.nextval,?,?,?,?,?,?,?,?)");
			
			
			
		
			preparedStatement.setString(1, customer.getFirstname());
			preparedStatement.setString(2, customer.getLastname());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.setString(5, customer.getPanNo());
			preparedStatement.setString(6,customer.getAadharCardNo());
			preparedStatement.setString(7, customer.getAddress());
			preparedStatement.setString(8,customer.getMobileNo());
			
			
			 i = preparedStatement.executeUpdate();
			
			if(i==1) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "CAPGEMINI", "oracle123");
				preparedStatement = conn.prepareStatement("select * from customer_details where aadhaar_no = ?");
				preparedStatement.setString(1,customer.getAadharCardNo());
				ResultSet resultSet = preparedStatement.executeQuery();
				resultSet.next();
				accNo = resultSet.getInt(1);
			} catch(ClassNotFoundException e) {}
				catch (SQLException e) {
			}
			
			}
			
				
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
		}
		 {
			return -1;
		}
		
	}


		
		
	

	public Customer login(Customer customer) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "CAPGEMINI", "oracle123");
			
			java.sql.Statement st =   connection.createStatement();
			 ResultSet rs = ((java.sql.Statement) st).executeQuery("select * from customer_details");
			 int i = 0;
			 while(rs.next()) {
				 if(rs.getLong(1)==customer.getAccountNo()&& rs.getString(5).equals(customer.getPassword())) {
					 customer.setBalance(rs.getLong(10));
					 customer.setFirstname(rs.getString(2));
					 i++;
					 break;
				 }
					 
				
			 }
			 if(i !=1)
				 customer.setFirstname(null);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
		
		
		
	}

}
