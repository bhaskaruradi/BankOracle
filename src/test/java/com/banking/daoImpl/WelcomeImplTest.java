package com.banking.daoImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.banking.ui.Customer;

class WelcomeImplTest {

	
	static WelcomeImpl w;
	@Before
	public static void init() {
		w= new WelcomeImpl();
	}
	
	@Test
	void RegTest() {
	  Customer c =new Customer();
	  c.setFirstname("bhaskar");
	  c.setLastname("uradi");
	  c.setEmail("bhas@");
	  c.setPassword("123456");
	  c.setPanNo("bhas154");
	  c.setAadharCardNo("441275847695");
	  c.setAddress("chilkoor");
	  c.setMobileNo("9948761996");
	  c.setBalance(3000);
	  assertEquals(1010,w.registration(c));
	}
	@Test
	void testLogin() {
		 Customer c =new Customer();
		 c.setPassword("789");
		 assertEquals(1010, w.login(c));
		
	}

}
