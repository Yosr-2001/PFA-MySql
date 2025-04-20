package com.example.payment_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	 @Autowired
	    private PaymentRepository paymentRepository;

	    @Autowired
	    private OrderClient orderClient;

	    public List<Payment> getAllPayments() {
	        return paymentRepository.findAll();
	    }

	public Payment processPayment(Payment payment) {
		try {
 			Order order = orderClient.getOrderById(payment.getOrderId());
			if (order != null) {
				payment.setStatus("SUCCESS");
				return paymentRepository.save(payment);
			} else {
				payment.setStatus("Order not found");
				return paymentRepository.save(payment);
			}
		} catch (Exception e) {
			System.err.println("Error processing payment: " + e.getMessage());
			throw new RuntimeException("Error processing payment");
		}
	}
}
