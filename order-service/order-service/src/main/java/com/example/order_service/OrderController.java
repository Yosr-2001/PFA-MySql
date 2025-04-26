package com.example.order_service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    /*   @Autowired*/
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

  /*  @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    } */
  @PostMapping
  public ResponseEntity<?> addOrder(@RequestBody Order order) {
      try {
          Order savedOrder = orderService.addOrder(order);
          return ResponseEntity.ok(savedOrder);
      } catch (IllegalArgumentException e) {
          logger.error("Invalid order data: {}", e.getMessage(), e);
          return ResponseEntity.badRequest().body("Invalid order data: " + e.getMessage());
      } catch (Exception e) {
          logger.error("Failed to add order: {}", e.getMessage(), e);
          return ResponseEntity.status(500).body("Internal Server Error while adding order.");
      }
  }
    @PutMapping("/{id}/pay")
    public Order payOrder(@PathVariable String id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            order.setStatus("PAID");
            return orderService.updateOrder(order);
        } else {
            throw new RuntimeException("Commande non trouvée !");
        } 
}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable String id) {
        try {
            orderService.deleteOrder(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

}