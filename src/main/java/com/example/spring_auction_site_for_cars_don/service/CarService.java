package com.example.spring_auction_site_for_cars_don.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_auction_site_for_cars_don.model.Car;
import com.example.spring_auction_site_for_cars_don.repository.CarDao;

@Service
public class CarService {

	@Autowired
	private CarDao carDao;

	public void create(Car car) {
		carDao.save(car);
	}

	public Optional<Car> retrieveOne(long carId) {
		return carDao.findById(carId);
	}

	public void update(Car car) {
		carDao.save(car);
	}

	public List<Car> retrieveAll() {
		return carDao.findAll();
	}

	public void delete(long carId) {
		carDao.deleteById(carId);
	}

}
