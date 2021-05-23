package com.example.spring_auction_site_for_cars_don;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring_auction_site_for_cars_don.model.Bid;
import com.example.spring_auction_site_for_cars_don.model.Buyer;
import com.example.spring_auction_site_for_cars_don.model.Car;
import com.example.spring_auction_site_for_cars_don.service.BidService;
import com.example.spring_auction_site_for_cars_don.service.BuyerService;
import com.example.spring_auction_site_for_cars_don.service.CarService;

@SpringBootTest
class BidTest {

	@Autowired
	private BidService bidService;

	@Autowired
	private BuyerService buyerService;

	@Autowired
	private CarService carService;

	private List<Buyer> allBuyers = new ArrayList<>();

	private List<Car> allCars = new ArrayList<>();

	@Test
	void test_thatABidCanbePersisted() {
		Buyer buyer = buyerService.retrieveOne(1).get();
		Car car = carService.retrieveOne(1).get();
		allBuyers.add(buyer);
		allCars.add(car);
		Bid bid = new Bid(allBuyers, allCars, LocalDate.now(), 56500);
		bidService.create(bid);
		assertTrue(bid.getBidId() > 0);
	}

	@Test
	void test_thatABidCanBeRetrievedById() {
		Bid bidFromDb = bidService.retrieveOne(1).get();
		assertEquals(1, bidFromDb.getBidId());
	}

	@Test
	void test_thatABidCanBeUpdated() {
		Bid bidToUpdate = bidService.retrieveOne(1).get();
		double amountBeforeUpdate = bidToUpdate.getAmount();
		bidToUpdate.setAmount(57000);
		bidService.upDate(bidToUpdate);
		Bid upDateBid = bidService.retrieveOne(1).get();
		double upDatedAmount = upDateBid.getAmount();
		assertNotEquals(upDatedAmount, amountBeforeUpdate);
	}

	@Test
	void test_thatABidCanBeDeleted() {
		int numberBeforeDeleting = bidService.retrieveAll().size();
		Long bidToDelete = bidService.retrieveOne(1).get().getBidId();
		bidService.delete(bidToDelete);
		int numberAfterDeleting = bidService.retrieveAll().size();
		assertNotEquals(numberAfterDeleting, numberBeforeDeleting);
	}

}
