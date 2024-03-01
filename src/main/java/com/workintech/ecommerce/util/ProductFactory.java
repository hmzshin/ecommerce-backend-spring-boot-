package com.workintech.ecommerce.util;

import org.springframework.stereotype.Component;

import com.workintech.ecommerce.dto.ProductRequestBody;
import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.entity.Product;
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

}
