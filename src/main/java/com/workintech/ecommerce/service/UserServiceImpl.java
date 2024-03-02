package com.workintech.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.workintech.ecommerce.dto.UserRequestBody;
import com.workintech.ecommerce.dto.UserResponse;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.exception.NotExistException;
import com.workintech.ecommerce.repository.UserRepository;
import com.workintech.ecommerce.util.EntityValidations;
import com.workintech.ecommerce.util.UserFactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserFactory userFactory;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse findById(Long id) {
        User user = findByIdUser(id);
        return userFactory.createUserResponse(user);
    }

    @SuppressWarnings("null")
    @Override
    public UserResponse save(UserRequestBody entity) {
        User user = userRepository.save(userFactory.createUser(entity));
        return userFactory.createUserResponse(user);

    }

    @SuppressWarnings("null")
    @Override
    public User findByIdUser(Long id) {
        EntityValidations.isIdValid("User", id);
        return userRepository.findById(id).orElseThrow(() -> new NotExistException("User", id));
    }

}
