package com.workintech.ecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.workintech.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.category.id = :id")
    List<Product> findAllByCategory(Pageable pageable, @Param("id") Long id);

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :filter, '%')) OR  LOWER(p.description) LIKE LOWER(CONCAT('%', :filter, '%'))")
    List<Product> findAllByFilter(Pageable pageable, @Param("filter") String filter);

    @Query("SELECT p FROM Product p")
    List<Product> findAllByLimit(Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId AND (LOWER(p.name) LIKE LOWER(CONCAT('%', :filter, '%')) OR LOWER(p.description) LIKE LOWER(CONCAT('%', :filter, '%')))")
    List<Product> findAllByCategoryAndFilter(Pageable pageable, @Param("categoryId") Long categoryId,
            @Param("filter") String filter);
}
