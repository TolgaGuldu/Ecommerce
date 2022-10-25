package com.ecommerce.pim.dtos.update;

import com.ecommerce.pim.models.Product;
import lombok.Data;

@Data
public class UpdatePriceRequestDto {
    private double price;

    private String currency;

    private Product product;
}
