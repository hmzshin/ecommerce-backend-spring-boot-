package com.workintech.ecommerce.service;

import java.util.List;

import com.workintech.ecommerce.entity.ProductImages;

public interface ProductImagesService {
    ProductImages save(ProductImages productImages);

    List<ProductImages> findAllById(Long id);
}
