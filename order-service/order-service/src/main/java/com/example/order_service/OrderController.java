package com.example.order_service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
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
}