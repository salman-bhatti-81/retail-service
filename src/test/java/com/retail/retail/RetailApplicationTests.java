package com.retail.retail;

import com.retail.retail.domain.Item;
import com.retail.retail.domain.User;
import com.retail.retail.usecase.service.RetailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.retail.retail.usecase.service.UserType.*;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RetailApplicationTests {

	@Autowired
	RetailService retailService;

	private List<Item> items;

	@BeforeEach
	public void setup(){
		items = new ArrayList<Item>();
		items.add(new Item("1111",200));
		items.add(new Item("222",300));
	}


	@Test
	void testGeneral() {
		User user = new User("testUser",GENERAL);
		double expectedAmount = 475.0;
		double result = retailService.calculateTotalBill(user,items);
		assertTrue(expectedAmount==result);
	}

	@Test
	void testAffiliate() {
		User user = new User("testUser",AFFILIATE);
		double expectedAmount = 450.0;
		double result = retailService.calculateTotalBill(user,items);
		assertTrue(expectedAmount==result);
	}

	@Test
	void testCustomer() {
		User user = new User("testUser", CUSTOMER);
		double expectedAmount = 475.0;
		double result = retailService.calculateTotalBill(user,items);
		assertTrue(expectedAmount==result);
	}

	@Test
	void testEmployee() {
		User user = new User("testUser", EMPLOYEE);
		double expectedAmount = 350.0;
		double result = retailService.calculateTotalBill(user,items);
		assertTrue(expectedAmount==result);
	}

}
