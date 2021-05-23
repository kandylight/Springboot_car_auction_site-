package com.example.spring_auction_site_for_cars_don;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring_auction_site_for_cars_don.model.User;
import com.example.spring_auction_site_for_cars_don.service.UserService;

@SpringBootTest
class UserTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	void test_thatAUserCanBeRetrievedById() {
		User userFromDb = userService.retrieveOne(1).get();
		assertEquals(1, userFromDb.getUserId());
	}

	

}
