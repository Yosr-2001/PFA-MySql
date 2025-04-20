package com.example.product_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
	 @Autowired
	    private ProductRepository productRepository;

	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    public Product getProductById(String id) {
	        return productRepository.findById(id).orElse(null);
	    }

	    public Product addProduct(Product product) {
	        return productRepository.save(product);
	    }
}
