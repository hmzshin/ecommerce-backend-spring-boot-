package com.workintech.ecommerce.service;

import java.util.List;

import com.workintech.ecommerce.entity.Role;

public interface RoleService {

    Role findById(Long id);

    List<Role> findAll();

}
