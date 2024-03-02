package com.workintech.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductInOrder {
    private Long productId;
    private Integer numberOfProduct;
    private String detail;
}
