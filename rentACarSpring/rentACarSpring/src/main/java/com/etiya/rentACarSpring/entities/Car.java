package com.etiya.rentACarSpring.entities;

public class Car {
	private int id;
	private int brandId;
	private int colorId;
	private int modelYear;
	private String description;
	
	public Car() {
		super();
	}

	public Car(int id, int brandId, int colorId, int modelYear, String description) {
		super();
		this.id = id;
		this.brandId = brandId;
		this.colorId = colorId;
		this.modelYear = modelYear;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
