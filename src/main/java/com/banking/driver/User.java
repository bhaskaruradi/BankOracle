package com.banking.driver;

import java.util.Scanner;

import com.banking.service.Service;
import com.banking.service.ServiceTransaction;
import com.banking.serviceImpl.ServiceImpl;
import com.banking.serviceImpl.ServiceTransactionImpl;
import com.banking.ui.Customer;
import com.banking.ui.TransationPojo;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner sc = new Scanner(System.in);
       Service s = new ServiceImpl();
       ServiceTransaction st = new ServiceTransactionImpl();
       Customer customer = new Customer();
       TransationPojo tp = new TransationPojo();
       
       System.out.println("enter the choice");
       System.out.println("1.Registration");
       System.out.println("2.login");
       int ch = sc.nextInt();
       switch(ch) {
       case 1 :
    	   System.out.println("enter the first name");
      	   customer.setFirstname(sc.next());
      	   System.out.println("enter the last name");
      	   customer.setLastname(sc.next());
      	   System.out.println("enter email");
      	   customer.setEmail(sc.next());
      	   System.out.println("enter password");
      	   customer.setPassword(sc.next());
      	   System.out.println("enter pan number");
      	   customer.setPanNo(sc.next());
      	   System.out.println("enter aadhar num");
      	   customer.setAadharCardNo(sc.next());
      	   System.out.println("enter address");
      	   customer.setAddress(sc.next());
      	   System.out.println("enter the mobile num");
      	   customer.setMobileNo(sc.nextLong());
      	    
    	       s.registration();
    	       System.out.println("your acciount num"+customer.getAccountNo());
    	      // s.validateAdhar();
    	  break;
       case 2 :
    	   System.out.println("enter the account number");
    	   customer.setAccountNo(sc.nextLong());
    	   System.out.println("password");
    	   customer.setPassword(sc.next());
    	    Customer as = s.login(customer);
    	   if(as!=null)
    	   {
    		   System.out.println("enter the choice");
    		   System.out.println("1.withdraw");
    		   System.out.println("2.deposit");
    		   System.out.println("3.show balance");
    		   System.out.println("4.fund transfer");
    		   
    		   switch(ch) {
    		   case 1:
    			   System.out.println("enter the amount to be debited");
    			   tp.setAmount(sc.nextLong());
    			   st.withDraw(customer);
    		   case 2 :
    			   st.deposit(customer);
    		   case 3 :
    			   st.showBalance(customer);
    		   case 4 :
    			   st.fundTransfer();
    		   }
    	   }
    	   
       }
	}

}
