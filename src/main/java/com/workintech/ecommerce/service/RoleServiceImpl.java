package com.workintech.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.workintech.ecommerce.entity.Role;
import com.workintech.ecommerce.exception.NotExistException;
import com.workintech.ecommerce.repository.RoleRepository;
import com.workintech.ecommerce.util.EntityValidations;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @SuppressWarnings("null")
    @Override
    public Role findById(Long id) {
        EntityValidations.isIdValid("Role", id);
        return roleRepository.findById(id).orElseThrow(() -> new NotExistException("Role", id));
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

}
