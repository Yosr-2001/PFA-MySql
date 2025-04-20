package com.example.inventory_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
	 @Autowired
	    private InventoryRepository inventoryRepository;

	    public List<Inventory> getAllInventory() {
	        return inventoryRepository.findAll();
	    }

	    public Inventory getInventoryByProductId(String productId) {
	        return inventoryRepository.findById(productId).orElse(null);
	    }

	public Inventory addInventory(String productId, int quantity) {
		Inventory inventory = inventoryRepository.findById(productId)
				.orElse(new Inventory());
		inventory.setProductId(productId);
		inventory.setQuantity(inventory.getQuantity() + quantity);
		return inventoryRepository.save(inventory);
	}
	    public Inventory updateInventory(String productId, int quantity) {
	        Inventory inventory = inventoryRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
	        inventory.setQuantity(quantity);
	        return inventoryRepository.save(inventory);
	    }
}
