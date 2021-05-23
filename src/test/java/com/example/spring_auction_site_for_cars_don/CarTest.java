package com.example.spring_auction_site_for_cars_don;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.spring_auction_site_for_cars_don.model.Car;
import com.example.spring_auction_site_for_cars_don.model.Seller;
import com.example.spring_auction_site_for_cars_don.service.CarService;
import com.example.spring_auction_site_for_cars_don.service.SellerService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CarTest {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private SellerService sellerService;
	
	@Test
	void test_thatACarCanBePersisted() {
		Seller seller = sellerService.retrieveOne(1).get();
		Car car = new Car("Tesla", "Model-S", "Electric", "Automatic", "Black", 0, 56000, "delivery available", seller);
		carService.create(car);
		assertTrue(car.getCarId() > 0);
	}
	
	@Test
	void test_thatACarCanBeRetrievedById() {
		Car carFromDb = carService.retrieveOne(1).get();
		assertEquals(1, carFromDb.getCarId());
	}
	
	@Test
	void test_thatACarCanBeUpdated() {
		Car carToUpadate = carService.retrieveOne(1).get();
		String descriptionBeforeUpdate = carToUpadate.getDescription();
		carToUpadate.setDescription("updated description");
		carService.update(carToUpadate);
		Car updateCar = carService.retrieveOne(1).get();
		String updatedDescription = updateCar.getDescription();
		assertNotEquals(updatedDescription, descriptionBeforeUpdate);
	}
	
	@Test
	void test_thatACarCanBeDeleted() {
		int numberBeforeDeleting = carService.retrieveAll().size();
		Long carToDelete = carService.retrieveOne(1).get().getCarId();
		carService.delete(carToDelete);
		int numberAfterDeleting = carService.retrieveAll().size();
		assertNotEquals(numberAfterDeleting, numberBeforeDeleting);
	}

	

}
