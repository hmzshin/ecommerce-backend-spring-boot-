package com.workintech.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.ecommerce.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
