package com.ecommerce.om.dtos.other;

import com.ecommerce.om.models.Origin;
import lombok.Data;

@Data
public class ProductDto {
    private String name;

    private String pictureUrl;

    private String description;

    private Origin origin;

    private double height;

    private double weight;

    private Long category_id;

    private Long price_id;

    private Long stock_id;
}
