package com.ecommerce.pim.dtos.create;

import com.ecommerce.pim.models.Product;
import lombok.Data;

@Data
public class CreatePriceRequestDto {
    private double price;

    private String currency;

    private Product product;
}
