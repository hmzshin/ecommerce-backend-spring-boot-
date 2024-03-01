package com.workintech.ecommerce.service;

import java.util.List;

import com.workintech.ecommerce.entity.Store;

public interface StoreService {
    List<Store> findAll();

    Store findById(Long id);

    Store save(Store product);
}
