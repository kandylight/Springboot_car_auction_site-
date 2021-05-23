package com.example.spring_auction_site_for_cars_don.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_auction_site_for_cars_don.model.User;

public interface UserDao extends JpaRepository<User, Long> {

	User getByUsernameAndPassword(String username, String password);

}
