package com.ecommerce.pim.dtos.create;

import com.ecommerce.pim.models.Category;
import com.ecommerce.pim.models.Origin;
import com.ecommerce.pim.models.Price;
import com.ecommerce.pim.models.Stock;
import lombok.Data;

import javax.persistence.*;

@Data
public class CreateProductRequestDto {
    private String name;

    private String pictureUrl;

    private String description;

    private Origin origin;

    private double height;

    private double weight;

    private Category category;

    private Price price;

    private Stock stock;
}
