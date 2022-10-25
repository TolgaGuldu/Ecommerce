package com.ecommerce.pim.dtos.create;

import com.ecommerce.pim.models.Product;
import lombok.Data;

@Data
public class CreateStockRequestDto {
    private int amount;

    private Boolean available;

    private Product product;
}
