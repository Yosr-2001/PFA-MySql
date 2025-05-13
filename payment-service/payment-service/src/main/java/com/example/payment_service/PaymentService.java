package com.example.payment_service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

@Service
public class PaymentService {
	 @Autowired
	    private PaymentRepository paymentRepository;

	    @Autowired
	    private OrderClient orderClient;

	    public List<Payment> getAllPayments() {
	        return paymentRepository.findAll();
	    }
	private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);


	public Payment processPayment(Payment payment) {
		// Assuming payment validation and logic
		if (payment.getOrderId() == null || payment.getAmount() <= 0) {
			throw new IllegalArgumentException("Invalid payment details");
		}
		// Save to DB
		return paymentRepository.save(payment);
	}


}
