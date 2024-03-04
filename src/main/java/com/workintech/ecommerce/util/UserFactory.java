package com.workintech.ecommerce.util;

import org.springframework.stereotype.Component;

import com.workintech.ecommerce.dto.UserRequestBody;
import com.workintech.ecommerce.dto.UserResponse;
import com.workintech.ecommerce.entity.Role;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.exception.ConflictException;
import com.workintech.ecommerce.service.RoleService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UserFactory {

    private RoleService roleService;

    public User createUser(UserRequestBody userRequestBody) {

        EntityValidations.isUserCredentialsValid(userRequestBody);

        User user = new User();
        user.setName(userRequestBody.getName());
        user.setSurname(userRequestBody.getSurname());
        user.setEmail(userRequestBody.getEmail());
        user.setPassword(userRequestBody.getPassword());
        Role role = roleService.findById(userRequestBody.getRoleId());
        user.setRole(role);

        if (role.getCode().equals("store")) {
            if (userRequestBody.getStore() == null) {
                throw new ConflictException(
                        "Please check your payload because you try to save a store user without store information");
            }
            EntityValidations.isStoreCredentialsValid(userRequestBody.getStore());
            user.setStore(userRequestBody.getStore());
        }

        if (!role.getCode().equals("store") && userRequestBody.getStore() != null) {
            throw new ConflictException(
                    "Please check your payload because you try to save a non store user with store information");
        }


        return user;
    }

    public UserResponse createUserResponse(User user) {
        UserResponse userResponse;
        if (user.getStore() == null) {
            userResponse = new UserResponse(user.getName(), user.getSurname(), user.getEmail(),
                    user.getRole().getId(), null);
        } else {
            userResponse = new UserResponse(user.getName(), user.getSurname(), user.getEmail(),
                    user.getRole().getId(), user.getStore().getId());

        }

        return userResponse;
    }

}
