package com.ecommerce.pim.dtos.update;

import com.ecommerce.pim.models.Product;
import lombok.Data;

@Data
public class UpdateStockRequestDto {
    private int amount;

    private Boolean available;

    private Product product;
}
