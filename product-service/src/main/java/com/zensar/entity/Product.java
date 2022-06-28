package com.zensar.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productName;
	private String description;
	private Double price;
	
	@Transient
	private String couponCode;
	

	/*
	 * public Product() { super(); }
	 * 
	 * public Product(int productId, String productName, String description, Double
	 * price) { super(); this.productId = productId; this.productName = productName;
	 * this.description = description; this.price = price; }
	 * 
	 * public int getProductId() { return productId; }
	 * 
	 * public void setProductId(int productId) { this.productId = productId; }
	 * 
	 * public String getProductName() { return productName; }
	 * 
	 * public void setProductName(String productName) { this.productName =
	 * productName; }
	 * 
	 * public String getDescription() { return description; }
	 * 
	 * public void setDescription(String description) { this.description =
	 * description; }
	 * 
	 * public Double getPrice() { return price; }
	 * 
	 * public void setPrice(Double price) { this.price = price; }
	 * 
	 * @Override public String toString() { return "Product [productId=" + productId
	 * + ", productName=" + productName + ", description=" + description +
	 * ", price=" + price + "]"; }
	 */
}
