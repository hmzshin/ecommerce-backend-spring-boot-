package com.workintech.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserResponse {

    private String name;

    private String surname;

    private String email;

    private Long roleId;

    private Long storeId;

}
