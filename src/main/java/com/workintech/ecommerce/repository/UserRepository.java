package com.workintech.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.ecommerce.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
