package com.workintech.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.ecommerce.entity.Role;
import com.workintech.ecommerce.service.RoleService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/roles")
public class RoleController {

    private RoleService roleService;

    @GetMapping
    public List<Role> findAll() {
        return roleService.findAll();
    }
}
