package com.workintech.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.workintech.ecommerce.entity.Address;
import com.workintech.ecommerce.exception.NotExistException;
import com.workintech.ecommerce.repository.AddressRepository;
import com.workintech.ecommerce.util.EntityValidations;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Address findById(Long id) {
        EntityValidations.isIdValid("Address", id);
        return addressRepository.findById(id).orElseThrow(() -> new NotExistException("Address", id));
    }

    @SuppressWarnings("null")
    @Override
    public Address save(Address address) {
        EntityValidations.isAddressCredentialsValid(address);
        return addressRepository.save(address);
    }

}
