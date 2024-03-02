package com.workintech.ecommerce.dto;

import java.util.List;

import com.workintech.ecommerce.entity.PaymentInformation;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderRequest {

    private String status;

    private Long userId;

    private Long shippingAddressId;

    private Long billingAddressId;

    private List<ProductInOrder> products;

    private PaymentInformation paymentInformation;
}
