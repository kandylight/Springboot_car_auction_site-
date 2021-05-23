package com.example.spring_auction_site_for_cars_don;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring_auction_site_for_cars_don.model.Buyer;
import com.example.spring_auction_site_for_cars_don.service.BuyerService;

@SpringBootTest
class BuyerTest {

	@Autowired
	private BuyerService buyerService;

	@Test
	void test_thatABuyerCanBePersisted() {
		Buyer buyer = new Buyer("Sam Buttler", "7 Dean Drive Winsford CW6 3BC");
		buyerService.create(buyer);
		assertTrue(buyer.getBuyerId() > 0);
	}

	@Test
	void test_thatABuyerCanBeRetrievedById() {
		Buyer buyerFromDb = buyerService.retrieveOne(1).get();
		assertEquals(1, buyerFromDb.getBuyerId());
	}

	@Test
	void test_thatABuyerCanBeUpdated() {
		Buyer buyerToUpdate = buyerService.retrieveOne(1).get();
		String addressBeforeUpdate = buyerToUpdate.getBuyerAddress();
		buyerToUpdate.setBuyerAddress("updated address");
		buyerService.update(buyerToUpdate);
		Buyer updateBuyer = buyerService.retrieveOne(1).get();
		String updateAddress = updateBuyer.getBuyerAddress();
		assertNotEquals(addressBeforeUpdate, updateAddress);
	}

	@Test
	void test_thatABuyerCanBeDeleted() {
		int numberBeforeDeleting = buyerService.retrieveAll().size();
		Long buyerToDelete = buyerService.retrieveOne(2).get().getBuyerId();
		buyerService.delete(buyerToDelete);
		int numberAfterDeleting = buyerService.retrieveAll().size();
		assertNotEquals(numberAfterDeleting, numberBeforeDeleting);
	}

}
