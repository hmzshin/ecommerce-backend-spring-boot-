package com.workintech.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.workintech.ecommerce.dto.OrderRequest;
import com.workintech.ecommerce.dto.OrderResponse;
import com.workintech.ecommerce.entity.Order;
import com.workintech.ecommerce.repository.OrderRepository;
import com.workintech.ecommerce.util.EntityValidations;
import com.workintech.ecommerce.util.OrderFactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderFactory orderFactory;

    @Override
    public OrderResponse makeOrder(OrderRequest orderRequest) {
        Order o = orderFactory.createOrder(orderRequest);
        @SuppressWarnings("null")
        Order oSaved = orderRepository.save(o);
        return orderFactory.createOrderResponse(oSaved);
    }

    @Override
    public List<OrderResponse> findAllByUser(Long userId) {
        EntityValidations.isIdValid("User", userId);
        List<Order> orders = orderRepository.findAllByUser(userId);
        List<OrderResponse> orderRequests = new ArrayList<>();
        for (Order o : orders) {
            orderRequests.add(orderFactory.createOrderResponse(o));
        }
        return orderRequests;
    }

}
