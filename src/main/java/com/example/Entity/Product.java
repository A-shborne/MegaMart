package com.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@Column(name = "product_id")
	private String productId;
	@Column(name = "product_name")
	private String ProductName;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private double price;
	@Column(name = "doscount")
	private double discount;
	@Column(name = "delivery_charges")
	private double deliveryCharges;
	@Column(name = "avg_rating")
	private Integer averageRating;
	@Column(name = "seller_name")
	private String sellerName;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
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
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getDeliveryCharges() {
		return deliveryCharges;
	}
	public void setDeliveryCharges(double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}
	public Integer getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Integer averageRating) {
		this.averageRating = averageRating;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	

}
