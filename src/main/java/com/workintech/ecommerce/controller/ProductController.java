package com.workintech.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.ecommerce.dto.ProductRequestBody;
import com.workintech.ecommerce.dto.ProductResponse;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.entity.ProductImages;
import com.workintech.ecommerce.service.ProductService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<ProductResponse> findAllBy(
            @RequestParam(name = "category", required = false) Long categoryId,
            @RequestParam(name = "filter", defaultValue = "") String filter,
            @RequestParam(name = "limit", defaultValue = "5") Integer limit,
            @RequestParam(name = "sort", defaultValue = "") String sort) {

        return productService.findAllBy(categoryId, filter, limit, sort);
    }

    @GetMapping(path = "/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping(path = "/images/{id}")
    public List<ProductImages> findAllImages(@PathVariable Long id) {
        return productService.findAllImages(id);
    }

    @PostMapping(path = "/save")
    public ProductResponse save(@RequestBody ProductRequestBody product) {
        return productService.save(product);
    }

}
