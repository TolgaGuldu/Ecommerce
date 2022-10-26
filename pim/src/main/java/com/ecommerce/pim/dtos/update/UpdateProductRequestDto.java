package com.ecommerce.pim.dtos.update;

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
public class UpdateProductRequestDto {
    private String name;

    private String pictureUrl;

    private String description;

    private Origin origin;

    private Double height;

    private Double weight;

    private Long categoryid;

    private Double price;

    private Integer stock;
}
