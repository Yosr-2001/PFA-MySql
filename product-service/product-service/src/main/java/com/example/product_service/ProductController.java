package com.example.product_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
	  @Autowired
	    private ProductService productService;

	    @GetMapping
	    public List<Product> getAllProducts() {
	        return productService.getAllProducts();
	    }

	    @GetMapping("/{id}")
	    public Product getProductById(@PathVariable String id) {
	        return productService.getProductById(id);
	    }

	    @PostMapping
	    public Product addProduct(@RequestBody Product product) {
	        return productService.addProduct(product);
	    }
}
