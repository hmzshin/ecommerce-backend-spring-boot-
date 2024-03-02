package com.workintech.ecommerce.util;

import org.springframework.stereotype.Component;

import com.workintech.ecommerce.dto.ProductImagesRequestBody;
import com.workintech.ecommerce.dto.ProductImagesResponse;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.entity.ProductImages;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductImagesFactory {

    public ProductImages createProductImages(ProductImagesRequestBody entity, Product product) {
        EntityValidations.isProductImagesCredentialsValid(entity);
        ProductImages productImages = new ProductImages();
        productImages.setIndex(entity.getIndex());
        productImages.setUrl(entity.getUrl());
        productImages.setProduct(product);

        return productImages;
    }

    public ProductImagesResponse createProductImagesResponse(ProductImages entity) {
        ProductImagesResponse productImagesResponse = new ProductImagesResponse();
        productImagesResponse.setIndex(entity.getIndex());
        productImagesResponse.setUrl(entity.getUrl());

        return productImagesResponse;
    }
}
