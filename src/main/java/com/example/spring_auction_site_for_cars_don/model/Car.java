package com.example.spring_auction_site_for_cars_don.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_gen")
	@SequenceGenerator(name = "car_gen", sequenceName = "car_seq", allocationSize = 1)
	private long carId;

	@Column
	private String make;

	@Column
	private String model;

	@Column
	private String fuelType;

	@Column
	private String transmission;

	@Column
	private String colour;

	@Column
	private int co2Emission;

	@Column
	private double price;

	@Column
	private String description;

	@ManyToOne
	@JoinColumn(name = "sellerId")
	private Seller seller;

	public Car() {
		super();
	}

	public Car(String make, String model, String fuelType, String transmission, String colour, int co2Emission,
			double price, String description, Seller seller) {
		super();
		this.make = make;
		this.model = model;
		this.fuelType = fuelType;
		this.transmission = transmission;
		this.colour = colour;
		this.co2Emission = co2Emission;
		this.price = price;
		this.description = description;
		this.seller = seller;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getCo2Emission() {
		return co2Emission;
	}

	public void setCo2Emission(int co2Emission) {
		this.co2Emission = co2Emission;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (carId ^ (carId >>> 32));
		result = prime * result + co2Emission;
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((fuelType == null) ? 0 : fuelType.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((seller == null) ? 0 : seller.hashCode());
		result = prime * result + ((transmission == null) ? 0 : transmission.hashCode());
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
		Car other = (Car) obj;
		if (carId != other.carId)
			return false;
		if (co2Emission != other.co2Emission)
			return false;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (fuelType == null) {
			if (other.fuelType != null)
				return false;
		} else if (!fuelType.equals(other.fuelType))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (seller == null) {
			if (other.seller != null)
				return false;
		} else if (!seller.equals(other.seller))
			return false;
		if (transmission == null) {
			if (other.transmission != null)
				return false;
		} else if (!transmission.equals(other.transmission))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", make=" + make + ", model=" + model + ", fuelType=" + fuelType
				+ ", transmission=" + transmission + ", colour=" + colour + ", co2Emission=" + co2Emission + ", price="
				+ price + ", description=" + description + ", seller=" + seller + "]";
	}

}
