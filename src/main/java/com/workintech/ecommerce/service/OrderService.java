package com.workintech.ecommerce.service;

import java.util.List;

import com.workintech.ecommerce.dto.OrderRequest;
import com.workintech.ecommerce.dto.OrderResponse;

public interface OrderService {

    OrderResponse makeOrder(OrderRequest orderRequest);

    List<OrderResponse> findAllByUser(Long id);

}
