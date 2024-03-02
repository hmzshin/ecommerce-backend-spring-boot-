package com.workintech.ecommerce.service;

import org.springframework.stereotype.Service;

import com.workintech.ecommerce.dto.OrderRequest;
import com.workintech.ecommerce.dto.OrderResponse;
import com.workintech.ecommerce.entity.Order;
import com.workintech.ecommerce.repository.OrderRepository;
import com.workintech.ecommerce.util.OrderFactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderFactory orderFactory;

    @SuppressWarnings("null")
    @Override
    public OrderResponse makeOrder(OrderRequest orderRequest) {
        Order o = orderFactory.createOrder(orderRequest);
        Order oSaved = orderRepository.save(o);
        return orderFactory.createOrderResponse(oSaved);
    }

}
