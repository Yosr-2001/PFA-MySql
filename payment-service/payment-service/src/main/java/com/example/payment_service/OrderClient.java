package com.example.payment_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service")
public interface OrderClient {
	@GetMapping("/orders/{id}")
    Order getOrderById(@PathVariable("id") Long id);
}
