package com.example.order_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	 @Autowired
	    private OrderRepository orderRepository;

	    @Autowired
	    private ProductClient productClient;

	    public Order updateOrder(Order order) {
	        if (orderRepository.existsById(order.getId())) {
	            return orderRepository.save(order); // Met à jour l'ordre existant
	        } else {
	            throw new RuntimeException("Commande non trouvée !");
	        }
	    }
	    public List<Order> getAllOrders() {
	        try {
	            List<Order> orders = orderRepository.findAll();
	            if (orders.isEmpty()) {
	                System.err.println("Aucune commande trouvée !");
	                throw new RuntimeException("Aucune commande trouvée !");
	            }
	            return orders;
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Erreur interne du serveur : " + e.getMessage());
	        }
	    }

	    public Order getOrderById(String id) {
	        return orderRepository.findById(id).orElse(null);
	    }

	    public Order addOrder(Order order) {
	    	 try {
	    	        Product product = productClient.getProductById(order.getProductId());
	    	        if (product != null) {
	    	            return orderRepository.save(order);
	    	        } else {
	    	            throw new RuntimeException("Product not found");
	    	        }
	    	    } catch (Exception e) {
	    	        // Log de l'erreur
	    	        System.err.println("Error while adding order: " + e.getMessage());
	    	        throw new RuntimeException("Error processing the order");
	    	    }
}}
