package com.ecommerce.pim.utils.mappers;

import com.ecommerce.pim.dtos.create.CreateCategoryRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdateCategoryRequestDto;
import com.ecommerce.pim.models.Category;

import java.util.Date;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

public class CategoryMapper {
    private CategoryMapper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }
    
    public static Category categoryCreateMapper(CreateCategoryRequestDto createCategoryRequestDto){
        Category category = new Category();
        category.setCategoryTitle(createCategoryRequestDto.getCategoryTitle());
        category.setParentCategory(createCategoryRequestDto.getParentCategory());
        category.setSubCategories(createCategoryRequestDto.getSubCategories());
        category.setImageUrl(createCategoryRequestDto.getImageUrl());
        category.setProducts(createCategoryRequestDto.getProducts());
        category.setAddedBy(0);
        category.setAddedDate(new Date());
        category.setModifiedBy(0);
        category.setModifiedDate(new Date());
        category.setActive('1');
        category.setLocked('0');
        category.setStatus('1');
        return category;
    }

    public static Category categoryUpdateMapper(UpdateCategoryRequestDto updateCategoryRequestDto, Category updatedCategory){
        updatedCategory.setCategoryTitle(updateCategoryRequestDto.getCategoryTitle());
        updatedCategory.setParentCategory(updateCategoryRequestDto.getParentCategory());
        updatedCategory.setSubCategories(updateCategoryRequestDto.getSubCategories());
        updatedCategory.setImageUrl(updateCategoryRequestDto.getImageUrl());
        updatedCategory.setProducts(updateCategoryRequestDto.getProducts());
        updatedCategory.setModifiedBy(0);
        updatedCategory.setModifiedDate(new Date());
        return updatedCategory;
    }

    public static Category categoryUpdateActiveMapper(UpdateActiveRequestDto updateActiveRequestDto, Category updatedCategory){
        updatedCategory.setActive(updateActiveRequestDto.getActive().charAt(0));
        return updatedCategory;
    }

}
