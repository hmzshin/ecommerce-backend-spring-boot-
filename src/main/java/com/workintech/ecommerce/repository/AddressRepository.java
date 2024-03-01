package com.workintech.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.ecommerce.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
