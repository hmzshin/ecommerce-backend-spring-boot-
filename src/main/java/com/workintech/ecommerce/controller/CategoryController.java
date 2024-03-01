package com.workintech.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.service.CategoryServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/categories")
public class CategoryController {
    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping
    public List<Category> findAll() {
        return categoryServiceImpl.findAll();
    }

    @PostMapping
    public Category save(@RequestBody Category category) {
        return categoryServiceImpl.save(category);
    }

}
