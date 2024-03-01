package com.workintech.ecommerce.dto;

import com.workintech.ecommerce.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequestBody {

    private String name;

    private String surname;

    private String email;

    private String password;

    private Long roleId;

    private Store store;

}
