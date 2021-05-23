package com.example.spring_auction_site_for_cars_don.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_auction_site_for_cars_don.model.Bid;
import com.example.spring_auction_site_for_cars_don.repository.BidDao;

@Service
public class BidService {

	@Autowired
	private BidDao bidDao;

	public void create(Bid bid) {
		bidDao.save(bid);
	}

	public Optional<Bid> retrieveOne(long bidId) {
		return bidDao.findById(bidId);
	}

	public void upDate(Bid bid) {
		bidDao.save(bid);
	}

	public List<Bid> retrieveAll() {
		return bidDao.findAll();
	}

	public void delete(long bidId) {
		bidDao.deleteById(bidId);
		
	}

}
