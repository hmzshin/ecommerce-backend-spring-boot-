package com.workintech.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.ecommerce.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
