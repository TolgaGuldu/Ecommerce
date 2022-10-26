package com.ecommerce.pim.dtos.update;

import com.ecommerce.pim.models.Product;
import lombok.Data;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@Data
public class UpdateStockRequestDto {
    private int amount;

    private Boolean available;

}
