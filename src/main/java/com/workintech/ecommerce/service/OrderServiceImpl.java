package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.OrderRequest;
import com.workintech.ecommerce.dto.OrderResponse;

public class OrderServiceImpl implements OrderService {

    @Override
    public OrderResponse makeOrder(OrderRequest orderRequest) {

        return new OrderResponse();
    }

}
