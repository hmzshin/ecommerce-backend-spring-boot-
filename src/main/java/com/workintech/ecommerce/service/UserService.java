package com.workintech.ecommerce.service;

import java.util.List;

import com.workintech.ecommerce.dto.UserRequestBody;
import com.workintech.ecommerce.dto.UserResponse;
import com.workintech.ecommerce.entity.User;

public interface UserService {

    List<User> findAll();

    UserResponse findById(Long id);

    User save(UserRequestBody userRequestBody);
}