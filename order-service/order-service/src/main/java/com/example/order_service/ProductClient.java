package com.example.order_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service",url = "http://localhost:8081")
public interface ProductClient {
	 @GetMapping("/products/{id}")
	    Product getProductById(@PathVariable String id);
}
