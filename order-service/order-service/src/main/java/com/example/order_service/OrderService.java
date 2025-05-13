package com.example.order_service;

import java.util.Collections;
import java.util.List;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class OrderService {
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	    private OrderRepository orderRepository;

	    @Autowired
	    private ProductClient productClient;

	public Order addOrder(Order order) {
		try {
			Product product = productClient.getProductById(order.getProductId());
			if (product == null) {
				logger.warn("Produit avec ID {} non trouvé", order.getProductId());
				throw new IllegalArgumentException("Produit inexistant");
			}

			logger.info("Produit trouvé : {}", product.getName());
			return orderRepository.save(order);
		} catch (FeignException e) {
			logger.error("Erreur Feign lors de la récupération du produit : {}", e.getMessage(), e);
			throw new IllegalArgumentException("Impossible de récupérer les informations du produit. Vérifiez le service distant.");
		} catch (IllegalArgumentException e) {
			throw e; // propagée au contrôleur
		} catch (Exception e) {
			logger.error("Erreur inattendue lors de l'ajout de commande : {}", e.getMessage(), e);
			throw new RuntimeException("Erreur interne du serveur");
		}
	}


	    public Order updateOrder(Order order) {
	        if (orderRepository.existsById(order.getId())) {
	            return orderRepository.save(order);
			} else {
			throw new RuntimeException("Commande non trouvée !");
	        }
	    }
	public List<Order> getAllOrders() {
		List<Order> orders = orderRepository.findAll();

		if (orders.isEmpty()) {
			// Utilise un logger plutôt que System.err
			//logger.warn("Aucune commande trouvée.");
			return Collections.emptyList();
		}

		return orders;
	}


	    public Order getOrderById(Long id) {

			return orderRepository.findById(id).orElse(null);
	    }

	public void deleteOrder(Long id) {
		if (!orderRepository.existsById(id)) {
			throw new RuntimeException("Commande introuvable !");
		}
		orderRepository.deleteById(id);
		logger.info("Commande supprimée avec succès : {}", id);
	}


}
