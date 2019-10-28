package com.laptrinhjavaweb.entity;

import java.io.File;
import java.sql.Timestamp;

public class Product {
	private int id;
	private String name;
	private String description;
	private double price;
	private int categoryId;
	private String categoryName;
	private int productTypeId;
	private String productTypeName;
	private String imageName;
	private byte[] imageData;
	private File imageFile;
	/*
	 * private String createdBy; private String modifiedBy;
	 */
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	
	public File getImageFile() {
		return imageFile;
	}
	public void setFileImage(File imageFile) {
		this.imageFile = imageFile;
	}
	public int getId() {
		return id;
	}

	/*
	 * public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
	 * public void setModifiedBy(String modifiedBy) { this.modifiedBy = modifiedBy;
	 * }
	 */public void setId(int id) {
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
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	
}
