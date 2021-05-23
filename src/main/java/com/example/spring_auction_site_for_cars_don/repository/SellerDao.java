package com.example.spring_auction_site_for_cars_don.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.spring_auction_site_for_cars_don.model.Seller;

public interface SellerDao extends JpaRepository<Seller, Long> {
	
	@Query (value = "select sellerId from seller s where s.sellerId = :sellerId and exists "
			+ " (select sellerId from car where sellerId = s.sellerId)", nativeQuery=true)

	List<Integer> checkSellerHasNoCars(@Param("sellerId")long sellerId);

}
