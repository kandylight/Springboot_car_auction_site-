package com.example.spring_auction_site_for_cars_don.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_auction_site_for_cars_don.model.Buyer;
import com.example.spring_auction_site_for_cars_don.repository.BuyerDao;

@Service
public class BuyerService {
	
	private static Logger LOGGER = LogManager.getLogger(BuyerService.class);
	
	@Autowired
	private BuyerDao buyerDao;
	
	public void create(Buyer buyer) {
		buyerDao.save(buyer);
	}

	public Optional<Buyer> retrieveOne(long buyerId) {
		return buyerDao.findById(buyerId);
	}

	public void update(Buyer buyer) {
		buyerDao.save(buyer);
	}

	public List<Buyer> retrieveAll() {
		return buyerDao.findAll();
	}

	public void delete(long buyerId) {
		buyerDao.deleteById(buyerId);
	}
	

}
