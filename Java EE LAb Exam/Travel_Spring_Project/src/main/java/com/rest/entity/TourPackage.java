package com.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TourPackage 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer packageId;
	
	@Column(length = 50)
	private String packageName;
	
	@Column(length = 50)
	private Integer duration;
	
	@Column(length = 50)
	private Double price;

	public TourPackage() {
		// TODO Auto-generated constructor stub
	}
	
	public TourPackage(Integer packageId, String packageName, Integer duration, Double price) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.duration = duration;
		this.price = price;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TourPackage [packageId=" + packageId + ", packageName=" + packageName + ", duration=" + duration
				+ ", price=" + price + "]";
	}
	
		
}
