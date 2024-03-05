package com.workintech.ecommerce.service;

import java.util.List;

import com.workintech.ecommerce.exception.ConflictException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;
    private UserFactory userFactory;
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse findById(Long id) {
        User user = findByIdUser(id);
        return userFactory.createUserResponse(user);
    }

    @Override
    public UserResponse save(UserRequestBody entity) {
        var userExist = userRepository.findByEmail(entity.getEmail());
        if (userExist.isPresent()) {
            throw new ConflictException("User with given email is already exist");
        }
        EntityValidations.isUserCredentialsValid(entity);
        User u = userFactory.createUser(entity);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        User user = userRepository.save(u);
        return userFactory.createUserResponse(user);

    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @SuppressWarnings("null")
    @Override
    public User findByIdUser(Long id) {
        EntityValidations.isIdValid("User", id);
        return userRepository.findById(id).orElseThrow(() -> new NotExistException("User", id));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByEmail(username);
    }

}
