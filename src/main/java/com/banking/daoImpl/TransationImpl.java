package com.banking.daoImpl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.banking.dao.Transaction;
import com.banking.service.ServiceTransaction;
import com.banking.serviceImpl.ServiceTransactionImpl;
import com.banking.ui.Customer;
import com.banking.ui.TransationPojo;

public class TransationImpl  implements Transaction{
Customer c = new Customer();
TransationPojo tr = new TransationPojo();
//ServiceTransaction s = new ServiceTransactionImpl();

	public Customer deposit(Customer customer) {
		// TODO Auto-generated method stub
		long bal = customer.getBalance();
		bal += customer.getAmount();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "CAPGEMINI", "oracle123");
			
			PreparedStatement stmt = connection
					.prepareStatement("update customer_details set balance = ? where acount_no = ?");
			stmt.setLong(2, customer.getAccountNo());
			stmt.setLong(1, (bal));
			stmt.executeUpdate();
			customer.setBalance((long) bal);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
			
	}

	public Customer withDraw(Customer customer) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "CAPGEMINI", "oracle123");
		
		java.sql.Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from customer_details");
		System.out.println(customer.getAccountNo());
		int i = 0;
		while (rs.next()) {
			if (rs.getInt(1) == customer.getAccountNo()) {
				long bal = customer.getBalance();
				if (bal >= customer.getAmount()) {
					bal -= customer.getAmount();
					try {
						PreparedStatement stmt1 = connection
								.prepareStatement("update customer_details set balance = ? where acount_no = ?");
						stmt1.setLong(2, customer.getAccountNo());
						stmt1.setInt(1, (int)bal);
						stmt1.executeUpdate();
						customer.setBalance(bal);
						i++;
						break;
					}catch (SQLException e) {
//						e.printStackTrace();
					}
				}
			}
		}
		}
					catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		return customer;
	}

	public Customer showBalance(Customer customer) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "CAPGEMINI", "oracle123");
			
			ResultSet resultSet;
			PreparedStatement preparedStatement = connection.prepareStatement("select * from customer_details where acount_no = ?");
			preparedStatement.setLong(1,customer.getAccountNo());
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			customer.setBalance(resultSet.getInt(10));
		
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customer;
		
		
	}

	public int fundTransfer(long fromAccountNo,long toAccountNo,long amount,long balance ) {
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		int toBalance = 0;
		int fromBalance = 0;
		int i = 0;
		System.out.println(fromAccountNo+" "+toAccountNo);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "CAPGEMINI", "oracle123");
			int c=0;
			java.sql.Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from customer_details");
			//c1.setAmount(amount);
			//c1.setAccountNo(toAccountNo);
			
			
			while(rs.next())
			{
				if(rs.getInt(1) == toAccountNo)
				{
					c++;
					c1.setAccountNo(toAccountNo);
					c1.setBalance(rs.getInt(10));
					c1.setAmount(amount);
				}
				
			}
			if(c == 1)
			{
				//System.out.println(c1.getAccountNo());
				deposit(c1);
				rs = st.executeQuery("select * from customer_details");
				while(rs.next())
				{
					if(rs.getInt(1) == fromAccountNo)
					{
						c2.setAccountNo(fromAccountNo);
						c2.setBalance(rs.getLong(10));
						c2.setAmount(amount);
					}
					
				}
				System.out.println(c2.getAccountNo());
				withDraw(c2);
				//System.out.println(c1.getAccountNo());
				i = insertAmt(fromAccountNo,toAccountNo,amount);
			}	
			
		} 
		 catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return i;
	}

	private int updateBalance(long fromBalance, long fromAccountNo) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "CAPGEMINI", "oracle123");
			PreparedStatement ps = connection.prepareStatement("update customer_details set balance = ? where acount_no = ?");
			ps.setLong(1, fromBalance);
			ps.setLong(2, fromAccountNo);
			i = ps.executeUpdate();
		}  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
		
	

	private int insertAmt(long fromAccountNo, long toAccountNo, long amount) {
		int i = 0;
		PreparedStatement ps = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "CAPGEMINI", "oracle123");
			ps = connection.prepareStatement("insert into transaction_details values(transaction_sequence.nextval,?,?,?)");
			ps.setLong(1, fromAccountNo);
			ps.setLong(2, toAccountNo);
			ps.setLong(3, amount);
			
			i = ps.executeUpdate();
		}  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

		
		
		
	}


