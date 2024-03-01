package com.workintech.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workintech.ecommerce.entity.ProductImages;

public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {

    @Query("SELECT i FROM ProductImages i WHERE i.product.id=:id")
    List<ProductImages> getAllImages(Long id);
}
