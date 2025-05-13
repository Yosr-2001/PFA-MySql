package com.example.order_service;

import jakarta.persistence.*;

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
@GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	private String productId;
	private int quantity;
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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


	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	public Order( String productId, int quantity, String status) {

		this.productId = productId;
		this.quantity = quantity;
		this.status = status;
	}

	public Order() {
	}
}
