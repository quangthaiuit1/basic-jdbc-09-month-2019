package com.laptrinhjavaweb.entity;

import java.sql.Blob;
import java.sql.Timestamp;

public class Product {
	private int id;
	private String name;
	private String description;
	private double price;
	private int categoryId;
	private int productTypeId;
	private String imageName;
	private Blob imageData;
	private String createdBy;
	private String modifiedBy;
	private Timestamp createdDay;
	private Timestamp modifiedDay;
	public int getId() {
		return id;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Blob getImageData() {
		return imageData;
	}
	public void setImageData(Blob imageData) {
		this.imageData = imageData;
	}
	public Timestamp getCreatedDay() {
		return createdDay;
	}
	public void setCreatedDay(Timestamp createdDay) {
		this.createdDay = createdDay;
	}
	public Timestamp getModifiedDay() {
		return modifiedDay;
	}
	public void setModifiedDay(Timestamp modifiedDay) {
		this.modifiedDay = modifiedDay;
	}
	
}