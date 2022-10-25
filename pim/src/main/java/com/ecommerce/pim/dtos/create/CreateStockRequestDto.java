package com.ecommerce.pim.dtos.create;

import com.ecommerce.pim.models.Product;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class CreateStockRequestDto {
    private int amount;

    private Boolean available;

    private Product product;
}
