package com.workintech.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductBase {
    private String name;

    private String description;

    private Double price;

    private Integer stock;

    private Double rating;

    private Long sellCount;

    private Long storeId;

    private Long categoryId;

}
