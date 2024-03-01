package com.workintech.ecommerce.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductResponse extends ProductBase {

    private List<ProductImagesResponse> images;
    private Long id;

    public ProductResponse(Long id, String name, String description,
            Double price, Integer stock,
            Double rating,
            Long sellCount, Long storeId, Long categoryId,
            List<ProductImagesResponse> images) {
        super(name, description, price, stock, rating, sellCount, storeId, categoryId);

        this.images = images;
        this.id = id;
    }

}
