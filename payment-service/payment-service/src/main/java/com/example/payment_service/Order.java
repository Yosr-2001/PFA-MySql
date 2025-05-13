package com.example.payment_service;

import jakarta.persistence.*;

public class Order {

	private Long id;
    private String productId;
    private int quantity;
    private String status;


		public Long getId() {
			return id;
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

	public void setId(Long id) {
		this.id = id;
	}


}
