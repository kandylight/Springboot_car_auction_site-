package com.example.spring_auction_site_for_cars_don.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_auction_site_for_cars_don.model.User;
import com.example.spring_auction_site_for_cars_don.repository.UserDao;

@Service
public class UserService {
	
	@Autowired 
	private UserDao userDao;

	public User getByUserNameAndPassword(String username, String password) {
		return userDao.getByUsernameAndPassword(username, password);
	}

	public Optional<User> retrieveOne(long userId) {
		return userDao.findById(userId);
	}
	
	

}
