package com.ecommerce.pim.dtos.create;

import com.ecommerce.pim.models.Category;
import com.ecommerce.pim.models.Product;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@Data
public class CreateCategoryRequestDto {
    @NotBlank
    private String categoryTitle;

    @NotBlank
    private String imageUrl;


    private Set<Category> subCategories;


    private Category parentCategory;

}
