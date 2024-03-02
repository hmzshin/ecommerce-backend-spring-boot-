package com.workintech.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.workintech.ecommerce.entity.Address;
import com.workintech.ecommerce.entity.PaymentInformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponse {

    private String status;

    private Address shippingAddress;

    private Address billingAddress;

    private List<ProductResponse> products;

    private PaymentInformation paymentInformation;

    public void addProductResponse(ProductResponse p) {
        if (this.products == null) {
            this.products = new ArrayList<>();
        }
        this.products.add(p);
    }

}
