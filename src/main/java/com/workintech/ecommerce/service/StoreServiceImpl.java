package com.workintech.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.workintech.ecommerce.entity.Store;
import com.workintech.ecommerce.repository.StoreRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StoreServiceImpl implements StoreService {

    private StoreRepository storeRepository;

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Store findById(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new RuntimeException("The store is not exist"));
    }

    @SuppressWarnings("null")
    @Override
    public Store save(Store entity) {

        return storeRepository.save(entity);
    }

}
