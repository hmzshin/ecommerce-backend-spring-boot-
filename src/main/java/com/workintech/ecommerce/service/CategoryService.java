package com.workintech.ecommerce.service;

import java.util.List;

import com.workintech.ecommerce.entity.Category;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    Category save(Category product);

}
