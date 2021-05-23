package com.example.spring_auction_site_for_cars_don.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seller_gen")
	@SequenceGenerator(name = "seller_gen", sequenceName = "seller_seq", allocationSize = 1)
	private long sellerId;

	@Column
	private String sellerName;

	@Column
	private String sellerAddress;

	@Column
	private String email;

	public Seller() {
		super();
	}

	public Seller(String sellerName, String sellerAddress, String email) {
		super();
		this.sellerName = sellerName;
		this.sellerAddress = sellerAddress;
		this.email = email;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((sellerAddress == null) ? 0 : sellerAddress.hashCode());
		result = prime * result + (int) (sellerId ^ (sellerId >>> 32));
		result = prime * result + ((sellerName == null) ? 0 : sellerName.hashCode());
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
		Seller other = (Seller) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (sellerAddress == null) {
			if (other.sellerAddress != null)
				return false;
		} else if (!sellerAddress.equals(other.sellerAddress))
			return false;
		if (sellerId != other.sellerId)
			return false;
		if (sellerName == null) {
			if (other.sellerName != null)
				return false;
		} else if (!sellerName.equals(other.sellerName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerName=" + sellerName + ", sellerAddress=" + sellerAddress
				+ ", email=" + email + "]";
	}

}
