package com.ecommerce.pim.dtos.create;

import com.ecommerce.pim.models.Product;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class CreatePriceRequestDto {
    private double price;

    private String currency;

    private Product product;
}
