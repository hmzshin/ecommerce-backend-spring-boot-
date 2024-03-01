package com.workintech.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductImagesRequestBody {

    private String url;

    private Integer index;

    private Long productId;

}
