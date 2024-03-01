package com.workintech.ecommerce.util;

import java.util.ArrayList;
import java.util.List;

import com.workintech.ecommerce.dto.ProductImagesResponse;
import com.workintech.ecommerce.dto.ProductResponse;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.entity.ProductImages;

public class ProductResponseFactory {

    public static List<ProductResponse> createProductResponse(List<Product> products) {

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

    public static ProductResponse createProductResponse(Product p, List<ProductImages> images) {

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
