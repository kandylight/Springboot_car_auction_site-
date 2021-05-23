package com.example.spring_auction_site_for_cars_don;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.spring_auction_site_for_cars_don.model.Seller;
import com.example.spring_auction_site_for_cars_don.service.SellerService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class SellerTest {

	@Autowired
	private SellerService sellerService;

	@Test
	void test_thatASellerCanBePersisted() {
		Seller seller = new Seller("Hounslow cars", "333 wellington road hounslow TW3 5HS", "hounslowcars@gmail.com");
		sellerService.create(seller);
		assertTrue(seller.getSellerId() > 0);
	}

	@Test
	void test_thatASellerCanBeRetrievedById() {
		Seller sellerFromDb = sellerService.retrieveOne(1).get();
		assertEquals(1, sellerFromDb.getSellerId());
	}

	@Test
	void test_thatASellerCanBeUpdated() {
		Seller sellerToUpdate = sellerService.retrieveOne(1).get();
		String addressBeforUpdate = sellerToUpdate.getSellerAddress();
		sellerToUpdate.setSellerAddress("updated address");
		sellerService.update(sellerToUpdate);
		Seller updateSeller = sellerService.retrieveOne(1).get();
		String updatedAddress = updateSeller.getSellerAddress();
		assertNotEquals(updatedAddress, addressBeforUpdate);
	}

	@Test
	void test_thatASellerCanBeDeleted() {
		int numberBeforeDeleting = sellerService.retrieveAll().size();
		Long sellerToDelete = sellerService.retrieveOne(1).get().getSellerId();
		sellerService.delete(sellerToDelete);
		int numberAfterDeleting = sellerService.retrieveAll().size();
		assertNotEquals(numberAfterDeleting, numberBeforeDeleting);
	}

}
