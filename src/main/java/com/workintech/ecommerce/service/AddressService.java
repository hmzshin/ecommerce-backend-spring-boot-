package com.workintech.ecommerce.service;

import java.util.List;

import com.workintech.ecommerce.entity.Address;

public interface AddressService {

    List<Address> findAll();

    Address findById(Long id);

    Address save(Address address);

}