package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.LoginDto;
import com.workintech.ecommerce.dto.UserResponse;

import com.workintech.ecommerce.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/login")
public class LoginController {

    private LoginService loginService;

    @PostMapping
    public UserResponse verifyUser(@RequestBody LoginDto loginDto) {
        return loginService.verifyUser(loginDto);
    }

}
