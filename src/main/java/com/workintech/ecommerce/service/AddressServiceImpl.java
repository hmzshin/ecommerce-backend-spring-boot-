package com.workintech.ecommerce.service;

import java.util.List;

import com.workintech.ecommerce.exception.ConflictException;
import org.springframework.stereotype.Service;

import com.workintech.ecommerce.dto.AddressDto;
import com.workintech.ecommerce.entity.Address;
import com.workintech.ecommerce.exception.NotExistException;
import com.workintech.ecommerce.repository.AddressRepository;
import com.workintech.ecommerce.util.AddressFactory;
import com.workintech.ecommerce.util.EntityValidations;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;
    private UserService userService;
    private AddressFactory addressFactory;

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


    @Override
    public List<AddressDto> findAllByUser(Long userId) {
        userService.findById(userId);
        List<Address> addresses = addressRepository.findAllByUser(userId);
        return addressFactory.createAddressDto(addresses);
    }

    @Override
    public AddressDto save(AddressDto addressDto, Long id) {
        EntityValidations.isIdValid("User", id);
        if (!id.equals(addressDto.getUserId())) {
            throw new ConflictException("User id provided in the request body is not matching with the id provided in the path.");
        }
        Address a = addressFactory.createAddress(addressDto);
        Address saved = addressRepository.save(a);
        return addressFactory.createAddressDto(saved);
    }

    @Override
    public AddressDto delete(AddressDto addressDto, Long userId) {
        if (!addressDto.getUserId().equals(userId)) {
            throw new ConflictException("You are not allowed to delete this address");
        }

        Address a = addressRepository.findById(addressDto.getId())
                .orElseThrow(() -> new NotExistException("Address", userId));
        if (a.getUser() == null) {
            throw new NotExistException("Address", userId);
        }
        a.setUser(null);
        Address addressSaved = addressRepository.save(a);
        return addressFactory.createAddressDto(addressSaved);
    }
}