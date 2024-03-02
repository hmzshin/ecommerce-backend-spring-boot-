package com.workintech.ecommerce.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.workintech.ecommerce.dto.ProductImagesResponse;
import com.workintech.ecommerce.dto.ProductRequestBody;
import com.workintech.ecommerce.dto.ProductResponse;
import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.entity.ProductImages;
import com.workintech.ecommerce.entity.Store;
import com.workintech.ecommerce.service.CategoryService;
import com.workintech.ecommerce.service.StoreService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductFactory {

    private CategoryService categoryService;
    private StoreService storeService;

    public Product createProduct(ProductRequestBody productRequestBody) {
        Product product = new Product();
        product.setName(productRequestBody.getName());
        product.setDescription(productRequestBody.getDescription());
        product.setPrice(productRequestBody.getPrice());
        product.setStock(productRequestBody.getStock());
        product.setRating(productRequestBody.getRating());
        product.setSellCount(productRequestBody.getSellCount());

        Category category = categoryService.findById(productRequestBody.getCategoryId());
        Store store = storeService.findById(productRequestBody.getStoreId());

        product.setCategory(category);
        product.setStore(store);

        return product;
    }

    public List<ProductResponse> createProductResponse(List<Product> products) {

        List<ProductResponse> response = new ArrayList<>();

        for (Product p : products) {
            List<ProductImagesResponse> imagesConverted = new ArrayList<>();

            for (ProductImages img : p.getImages()) {
                imagesConverted.add(ProductImagesResponseFactory.createProductImagesResponse(img));
            }

            ProductResponse productResponse = new ProductResponse(p.getId(), p.getName(), p.getDescription(),
                    p.getPrice(),
                    p.getStock(), p.getRating(), p.getSellCount(), p.getStore().getId(), p.getCategory().getId(),
                    imagesConverted);
            response.add(productResponse);

        }

        return response;
    }

    public ProductResponse createProductResponse(Product p, List<ProductImages> images) {

        List<ProductImagesResponse> imagesConverted = new ArrayList<>();

        for (ProductImages img : images) {
            imagesConverted.add(ProductImagesResponseFactory.createProductImagesResponse(img));
        }

        ProductResponse productResponse = new ProductResponse(p.getId(), p.getName(), p.getDescription(), p.getPrice(),
                p.getStock(), p.getRating(), p.getSellCount(), p.getStore().getId(), p.getCategory().getId(),
                imagesConverted);

        return productResponse;
    }

}
