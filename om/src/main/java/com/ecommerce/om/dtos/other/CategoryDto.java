package com.ecommerce.om.dtos.other;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@Data
public class CategoryDto {
    @NotBlank
    private String categoryTitle;

    @NotBlank
    private String imageUrl;


    private Set<CategoryDto> subCategories;


    private CategoryDto parentCategory;

}
