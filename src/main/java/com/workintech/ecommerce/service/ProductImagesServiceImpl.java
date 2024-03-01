package com.workintech.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.workintech.ecommerce.entity.ProductImages;
import com.workintech.ecommerce.repository.ProductImagesRepository;
import com.workintech.ecommerce.util.EntityValidations;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductImagesServiceImpl implements ProductImagesService {

    private ProductImagesRepository productImagesRepository;

    @SuppressWarnings("null")
    @Override
    public ProductImages save(ProductImages productImages) {
        return productImagesRepository.save(productImages);
    }

    @Override
    public List<ProductImages> findAllById(Long id) {
        EntityValidations.isIdValid("ProductImages", id);
        return productImagesRepository.getAllImages(id);
    }

}
