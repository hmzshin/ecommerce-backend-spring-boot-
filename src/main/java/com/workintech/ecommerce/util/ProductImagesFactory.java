package com.workintech.ecommerce.util;

import com.workintech.ecommerce.dto.ProductImagesRequestBody;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.entity.ProductImages;

public class ProductImagesFactory {

    public static ProductImages createProductImages(ProductImagesRequestBody entity, Product product) {
        EntityValidations.isProductImagesCredentialsValid(entity);
        ProductImages productImages = new ProductImages();
        productImages.setIndex(entity.getIndex());
        productImages.setUrl(entity.getUrl());
        productImages.setProduct(product);

        return productImages;
    }
}
