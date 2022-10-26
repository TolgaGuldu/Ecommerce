package com.ecommerce.om.dtos.other;

import com.ecommerce.om.models.Origin;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;

    private String name;

    private String pictureUrl;

    private String description;

    private Origin origin;

    private double height;

    private double weight;

    private CategoryDto category;

    private PriceDto price;

    private StockDto stock;
}
