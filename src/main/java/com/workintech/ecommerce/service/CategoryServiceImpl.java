package com.workintech.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.exception.NotExistException;
import com.workintech.ecommerce.repository.CategoryRepository;
import com.workintech.ecommerce.util.EntityValidations;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Category findById(Long id) {
        EntityValidations.isIdValid("Category", id);
        return categoryRepository.findById(id).orElseThrow(() -> new NotExistException("Category", id));
    }

    @SuppressWarnings("null")
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

}
