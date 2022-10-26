package com.ecommerce.pim.dtos.create;

import com.ecommerce.pim.models.Category;
import com.ecommerce.pim.models.Origin;
import com.ecommerce.pim.models.Price;
import com.ecommerce.pim.models.Stock;
import lombok.Data;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@Data
public class CreateProductRequestDto {
    private String name;

    private String pictureUrl;

    private String description;

    private Origin origin;

    private double height;

    private double weight;

    private CreateCategoryRequestDto category;

    private CreatePriceRequestDto price;

    private CreateStockRequestDto stock;
}
