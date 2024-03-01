package com.workintech.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.workintech.ecommerce.dto.ProductImagesRequestBody;
import com.workintech.ecommerce.dto.ProductRequestBody;
import com.workintech.ecommerce.dto.ProductResponse;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.entity.ProductImages;
import com.workintech.ecommerce.exception.NotExistException;
import com.workintech.ecommerce.repository.ProductRepository;
import com.workintech.ecommerce.util.EntityValidations;
import com.workintech.ecommerce.util.ProductFactory;
import com.workintech.ecommerce.util.ProductImagesFactory;
import com.workintech.ecommerce.util.ProductResponseFactory;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductFactory productFactory;
    private ProductImagesService productImagesService;

    @Override
    public List<ProductResponse> findAll() {
        List<Product> products = productRepository.findAll();
        return ProductResponseFactory.createProductResponse(products);
    }

    @SuppressWarnings("null")
    @Override
    public Product findById(Long id) {
        EntityValidations.isIdValid("Product", id);
        return productRepository.findById(id).orElseThrow(() -> new NotExistException("Product", id));

    }

    @SuppressWarnings("null")
    @Override
    public ProductResponse save(ProductRequestBody entity) {

        EntityValidations.isProductCredentialsValid(entity);
        Product product = productFactory.createProduct(entity);
        productRepository.save(product);

        for (ProductImagesRequestBody p : entity.getImages()) {
            p.setProductId(product.getId());
            ProductImages productImages = ProductImagesFactory.createProductImages(p, product);
            productImagesService.save(productImages);
        }

        List<ProductImages> images = productImagesService.findAllById(product.getId());

        ProductResponse productResponse = ProductResponseFactory.createProductResponse(product, images);

        return productResponse;
    }

    @Override
    public List<ProductImages> findAllImages(Long id) {
        return productImagesService.findAllById(id);
    }

    @Override
    public List<ProductResponse> findAllBy(Long categoryId, String filter, Integer limit, String sort) {
        List<Product> products = new ArrayList<>();

        Pageable pageable = PageRequest.of(0, limit, Sort.by("sellCount").descending());

        if (!sort.isEmpty() && sort != null) {
            String[] parts = sort.split(":");
            String fieldName = parts[0];
            String direction = parts[1];

            if (direction.toLowerCase().equals("asc")) {
                pageable = PageRequest.of(0, limit, Sort.by(fieldName).ascending());

            } else if (direction.equals("desc")) {
                pageable = PageRequest.of(0, limit, Sort.by(fieldName).descending());

            }
        }

        if (categoryId != null && filter.isEmpty()) {
            EntityValidations.isIdValid("Category", categoryId);
            products = productRepository.findAllByCategory(pageable, categoryId);
        }

        if (categoryId == null && !filter.isEmpty()) {
            products = productRepository.findAllByFilter(pageable, filter);
        }

        if (categoryId == null && filter.isEmpty() && limit != null) {
            products = productRepository.findAllByLimit(pageable);
        }

        if (categoryId != null && !filter.isEmpty()) {
            products = productRepository.findAllByCategoryAndFilter(pageable, categoryId, filter);
        }

        return ProductResponseFactory.createProductResponse(products);
    }

}
