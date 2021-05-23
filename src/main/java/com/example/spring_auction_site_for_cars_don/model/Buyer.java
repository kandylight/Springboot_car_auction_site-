package com.example.spring_auction_site_for_cars_don.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Buyer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buyer_gen")
	@SequenceGenerator(name = "buyer_gen", sequenceName = "buyer_seq", allocationSize = 1)
	private long buyerId;

	@Column
	private String buyerName;

	@Column
	private String buyerAddress;

	public Buyer() {
		super();
	}

	public Buyer(String buyerName, String buyerAddress) {
		super();
		this.buyerName = buyerName;
		this.buyerAddress = buyerAddress;
	}

	public long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buyerAddress == null) ? 0 : buyerAddress.hashCode());
		result = prime * result + (int) (buyerId ^ (buyerId >>> 32));
		result = prime * result + ((buyerName == null) ? 0 : buyerName.hashCode());
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
		Buyer other = (Buyer) obj;
		if (buyerAddress == null) {
			if (other.buyerAddress != null)
				return false;
		} else if (!buyerAddress.equals(other.buyerAddress))
			return false;
		if (buyerId != other.buyerId)
			return false;
		if (buyerName == null) {
			if (other.buyerName != null)
				return false;
		} else if (!buyerName.equals(other.buyerName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Buyer [buyerId=" + buyerId + ", buyerName=" + buyerName + ", buyerAddress=" + buyerAddress + "]";
	}

}
