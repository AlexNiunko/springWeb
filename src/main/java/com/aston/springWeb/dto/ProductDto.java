package com.aston.springWeb.dto;

import java.util.List;

public class ProductDto {
    private long productDtoId;
    private String productName;
    private String productPrice;
    private String amount;
    private ProductDescriptionDto description;
    private List<UserDto> buyers;
}
