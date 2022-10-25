package com.ecommerce.pim.dtos.update;

import com.ecommerce.pim.models.Product;
import lombok.Data;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

@Data
public class UpdateStockRequestDto {
    private int amount;

    private Boolean available;

    private Product product;
}
