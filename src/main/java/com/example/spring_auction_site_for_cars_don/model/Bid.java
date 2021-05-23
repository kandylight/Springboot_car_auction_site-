package com.example.spring_auction_site_for_cars_don.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Bid {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bid_gen")
	@SequenceGenerator(name = "bid_gen", sequenceName = "bid_seq", allocationSize = 1)
	private long bidId;

	@ManyToMany
	@JoinColumn(name = "buyerId")
	@JoinTable(name = "BID_BUYER")
	private List<Buyer> buyer;

	@ManyToMany
	@JoinColumn(name = "carId")
	@JoinTable(name = "BID_CAR")
	private List<Car> car;

	@Column
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private LocalDate bidDate;

	@Column
	private double amount;

	public Bid() {
		super();
	}

	public Bid(List<Buyer> buyer, List<Car> car, LocalDate bidDate, double amount) {
		super();
		this.buyer = buyer;
		this.car = car;
		this.bidDate = bidDate;
		this.amount = amount;
	}

	public long getBidId() {
		return bidId;
	}

	public void setBidId(long bidId) {
		this.bidId = bidId;
	}

	public List<Buyer> getBuyer() {
		return buyer;
	}

	public void setBuyer(List<Buyer> buyer) {
		this.buyer = buyer;
	}

	public List<Car> getCar() {
		return car;
	}

	public void setCar(List<Car> car) {
		this.car = car;
	}

	public LocalDate getBidDate() {
		return bidDate;
	}

	public void setBidDate(LocalDate bidDate) {
		this.bidDate = bidDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((bidDate == null) ? 0 : bidDate.hashCode());
		result = prime * result + (int) (bidId ^ (bidId >>> 32));
		result = prime * result + ((buyer == null) ? 0 : buyer.hashCode());
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bid other = (Bid) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (bidDate == null) {
			if (other.bidDate != null)
				return false;
		} else if (!bidDate.equals(other.bidDate))
			return false;
		if (bidId != other.bidId)
			return false;
		if (buyer == null) {
			if (other.buyer != null)
				return false;
		} else if (!buyer.equals(other.buyer))
			return false;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", buyer=" + buyer + ", car=" + car + ", bidDate=" + bidDate + ", amount="
				+ amount + "]";
	}

}
