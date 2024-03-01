package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.OrderRequest;
import com.workintech.ecommerce.dto.OrderResponse;

public interface OrderService {

    OrderResponse makeOrder(OrderRequest orderRequest);

}
