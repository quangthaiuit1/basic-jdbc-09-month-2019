package com.laptrinhjavaweb.model;

import java.sql.Blob;
import java.sql.Timestamp;

public class ProductModel {
	private int id;
	private String name;
	private String description;
	private double price;
	private int categoryId;
	private int productTypeId;
	private String imageName;
	private Blob imageData;
	private int createdBy;
	private int modifiedBy;
	private Timestamp createdDay;
	private Timestamp modifiedDay;
	public int getId() {
		return id;
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
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
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
