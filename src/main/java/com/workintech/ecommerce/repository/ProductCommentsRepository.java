package com.workintech.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.ecommerce.entity.ProductComments;

public interface ProductCommentsRepository extends JpaRepository<ProductComments, Long> {

}
