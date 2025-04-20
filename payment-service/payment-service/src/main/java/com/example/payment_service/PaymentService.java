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
	        Order order = orderClient.getOrderById(payment.getOrderId());
	        if (order != null) {
	            payment.setStatus("SUCCESS");
	            return paymentRepository.save(payment);
	        } else {
	        	payment.setStatus("Commande non trouvée");
	        	return paymentRepository.save(payment);
	            //*throw new RuntimeException("Commande non trouvée !");*//
	        }
	    }
}
