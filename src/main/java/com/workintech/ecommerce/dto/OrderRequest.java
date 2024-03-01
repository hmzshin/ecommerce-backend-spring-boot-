package com.workintech.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderRequest {

    private String status;

    private Long userId;

    private Long shippingAddressId;

    private Long billingAddressId;
}
