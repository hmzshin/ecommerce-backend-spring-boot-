package com.workintech.ecommerce.util;

import com.workintech.ecommerce.dto.ProductImagesResponse;
import com.workintech.ecommerce.entity.ProductImages;

public class ProductImagesResponseFactory {

    public static ProductImagesResponse createProductImagesResponse(ProductImages entity) {
        ProductImagesResponse productImagesResponse = new ProductImagesResponse();
        productImagesResponse.setIndex(entity.getIndex());
        productImagesResponse.setUrl(entity.getUrl());

        return productImagesResponse;
    }
}
