package com.ecommerce.pim.utils.mappers;

import com.ecommerce.pim.dtos.create.CreateCategoryRequestDto;
import com.ecommerce.pim.dtos.update.UpdateCategoryRequestDto;
import com.ecommerce.pim.models.Category;

import java.util.Date;

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
        category.setActive(true);
        category.setLocked(false);
        category.setStatus(true);
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

}
