package com.ecommerce.pim.dtos.create;

import com.ecommerce.pim.models.Product;
import lombok.Data;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

@Data
public class CreatePriceRequestDto {
    private double price;

    private String currency;

    private Product product;
}
