package com.example.spring_auction_site_for_cars_don.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_auction_site_for_cars_don.model.Seller;
import com.example.spring_auction_site_for_cars_don.repository.SellerDao;

@Service
public class SellerService {
	
	private static Logger LOGGER = LogManager.getLogger(SellerService.class);
	
	@Autowired
	private SellerDao sellerDao;

	public void create(Seller seller) {
		sellerDao.save(seller);
	}

	public Optional<Seller> retrieveOne(long sellerId) {
		return sellerDao.findById(sellerId);
	}

	public void update(Seller seller) {
		sellerDao.save(seller);
	}

	public List<Seller> retrieveAll() {
		return sellerDao.findAll();
	}

	public void delete(long sellerId) {
		if (sellerDao.checkSellerHasNoCars(sellerId).size() > 0) {
			LOGGER.info("This seller still has cars");
		}
		else {
			sellerDao.deleteById(sellerId);
		}
	}

}
