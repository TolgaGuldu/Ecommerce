package com.ecommerce.pim.services;

import com.ecommerce.pim.common.results.DataResult;
import com.ecommerce.pim.common.results.Result;
import com.ecommerce.pim.dtos.create.CreateCategoryRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdateCategoryRequestDto;
import com.ecommerce.pim.models.Category;

import java.util.List;

/**
 * Created on October 2022
 *
 * @author tolga
 */

public interface CategoryService {
    Result getCategoryById(String id);

    Result getCategoryByCategoryTitle(String CategoryTitle);

    DataResult<List<Category>> getCategoryByActive(int page, int limit, String type);

    DataResult<List<Category>> getCategoryByNonActive(int page, int limit, String type);

    DataResult<List<Category>> getAllCategoryofPage(int page, int limit, String type);

    DataResult<List<Category>> getAllCategoryofList();

    Result createCategory(CreateCategoryRequestDto createCategoryRequestDto);

    Result updateCategory(String id, UpdateCategoryRequestDto updateCategoryRequestDto);

    Result updateActiveCategory(String id, UpdateActiveRequestDto updateActiveRequestDto);

    Result softDeleteCategoryById(String id);

    Result hardDeleteCategoryById(String id);

    Result softDeleteCategoryByCategoryTitle(String categoryTitle);

    Result hardDeleteCategoryByCategoryTitle(String categoryTitle);
}
