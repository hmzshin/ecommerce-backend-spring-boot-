package com.workintech.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDto {

    private Long id;

    private String title;

    private String city;

    private String district;

    private String neighborhood;

    private String address;

    private String name;

    private String surname;

    private String phone;

    private Long userId;
}
