package com.workintech.ecommerce.service;

import java.util.List;

import com.workintech.ecommerce.dto.ProductRequestBody;
import com.workintech.ecommerce.dto.ProductResponse;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.entity.ProductImages;

public interface ProductService {

    List<ProductResponse> findAll();

    Product findById(Long id);

    ProductResponse save(ProductRequestBody product);

    List<ProductImages> findAllImages(Long id);

    List<ProductResponse> findAllBy(Long categoryId, String filter, Integer limit, String sort);

}
