package com.ecommerce.pim.dtos.create;

import com.ecommerce.pim.models.Category;
import com.ecommerce.pim.models.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class CreateCategoryRequestDto {
    @NotBlank
    private String categoryTitle;

    @NotBlank
    private String imageUrl;


    private Set<Category> subCategories;


    private Category parentCategory;


    private Set<Product> products;

}
