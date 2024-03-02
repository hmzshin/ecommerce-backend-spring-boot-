package com.workintech.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardDto {

    private Long id;

    private String nameOnCard;

    private String cardNo;

    private Integer expireYear;

    private Integer expireMonth;

    private Integer ccv;

    private Long userId;
}
