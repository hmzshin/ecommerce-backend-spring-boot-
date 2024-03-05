package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.LoginDto;
import com.workintech.ecommerce.dto.UserResponse;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.exception.ValidationException;
import com.workintech.ecommerce.util.EntityValidations;
import com.workintech.ecommerce.util.UserFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;

@Service
public class LoginService {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    private UserFactory userFactory;


    public UserResponse verifyUser(LoginDto loginDto) {
        EntityValidations.isLoginDtoCredentialsValid(loginDto);
        User u = userService.findByEmail(loginDto.getEmail());

        Boolean condition1 = u.getEmail().equals(loginDto.getEmail());
        Boolean condition2 = passwordEncoder.matches(loginDto.getPassword(), u.getPassword());

        if (condition1 & condition2) {
            return userFactory.createUserResponse(u);
        } else {
            throw new ValidationException("User name or user password is not correct", HttpStatus.BAD_REQUEST);
        }
    }
}
