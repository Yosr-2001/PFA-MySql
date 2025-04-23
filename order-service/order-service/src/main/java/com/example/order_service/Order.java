package com.example.order_service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
/*	 public Order(String id, String productId, int quantity, String status) {
		
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.status = status;
	}*/
	@Id
	    private String id;
	private String productId;
	private int quantity;
	private String status;

	    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	    // Constructeurs, getters et setters
	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
}
