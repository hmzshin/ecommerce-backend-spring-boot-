package com.workintech.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.ecommerce.dto.OrderRequest;
import com.workintech.ecommerce.dto.OrderResponse;
import com.workintech.ecommerce.service.OrderService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/order")
public class OrderController {

    private OrderService orderService;

    @GetMapping("/{id}")
    public List<OrderResponse> findAllByUser(@PathVariable Long id) {
        return orderService.findAllByUser(id);
    }

    @PostMapping
    public OrderResponse makeOrder(@RequestBody OrderRequest orderRequestBody) {
        return orderService.makeOrder(orderRequestBody);
    }

}
