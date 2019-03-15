package com.banking.driver;

import java.util.Scanner;

import com.banking.service.Service;
import com.banking.service.ServiceTransaction;
import com.banking.serviceImpl.ServiceImpl;
import com.banking.serviceImpl.ServiceTransactionImpl;
import com.banking.ui.Customer;
import com.banking.ui.TransationPojo;
import com.banking.utility.InvalidMobileException;
import com.banking.utility.custom;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner sc = new Scanner(System.in);
       Service s = new ServiceImpl();
       ServiceTransaction st = new ServiceTransactionImpl();
       Customer customer = new Customer();
       TransationPojo tp = new TransationPojo();
       Customer c1 = new Customer();
     
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
      	  if( s.isAadharNoCorrect( customer.getAadharCardNo() ))
      	  {
      		 System.out.println("enter address");
        	   customer.setAddress(sc.next());
        	   System.out.println("enter the mobile num");
        	   customer.setMobileNo(sc.next());
        	   if(s.isMobileNoCorrect(customer.getMobileNo())) {
        		      int accNo = s.registration(customer);
             	       System.out.println("Registration succesful"+accNo);
        	   }
        	   else
        	   {
        		   try {
        			   throw new InvalidMobileException();
        		   }catch(InvalidMobileException e) {};
        	   }
        	    
      	 
      	  }
      	  else {
      		  try {
      			  throw new custom();
      		  }catch(custom e) {};
      	  }
      		  
      	  
    	       
    	  break;
       case 2 :
    	   System.out.println("enter the account number");
    	   customer.setAccountNo(sc.nextLong());
    	   System.out.println("password");
    	   customer.setPassword(sc.next());
    	    c1 = s.login(customer);
    	   if(c1.getFirstname()!=null){
    	   
    	   do
    	   {
    		   System.out.println("enter the choice");
    		   System.out.println("1.withdraw");
    		   System.out.println("2.deposit");
    		   System.out.println("3.show balance");
    		   System.out.println("4.fund transfer");
    		   int key =sc.nextInt();
    		   switch(key) {
    		   case 1:
    			   System.out.println("enter the amount to be debited");
    			   c1.setAmount(sc.nextLong());
    			   c1 = st.withDraw(customer);
    			   System.out.println("Remaining balance: "+c1.getBalance());
					break;
    		   case 2 :
    			   System.out.println("enter the amount to be credited");
    			   c1.setAmount(sc.nextLong());
    			   st.deposit(customer);
    			   System.out.println("updated balance: "+c1.getBalance());
    			   break;
    		   case 3 :
    			   
    			   c1 = st.showBalance(c1);
    			   System.out.println(" balance: "+c1.getBalance());
    			   break;
    		   case 4 :
    			   System.out.println("Enter the amount to transfer");
					int tAmt = sc.nextInt();
					System.out.println("Enter the account no to which you want to transfer the money");
					int toAccNo = sc.nextInt();
					int details = st.fundTransfer(customer.getAccountNo(), toAccNo, tAmt, customer.getBalance());
					if(details != 0)
					System.out.println(tAmt+" Rs/- of money is transferred from "+customer.getAccountNo()+" to "+toAccNo);
					break;
    		   default:
    			   System.exit(0);
    			   
    		   }
    	   }while(true);
    	   
       }else 
    	   System.out.println("Invalid account number");
    	   break;
       
	} 
       
       
      
       

}
}