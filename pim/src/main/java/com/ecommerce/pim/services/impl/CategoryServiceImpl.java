package com.ecommerce.pim.services.impl;

import com.ecommerce.pim.common.constants.Constant;
import com.ecommerce.pim.common.results.*;
import com.ecommerce.pim.dtos.create.CreateCategoryRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdateCategoryRequestDto;
import com.ecommerce.pim.models.Category;
import com.ecommerce.pim.repositories.CategoryRepository;
import com.ecommerce.pim.services.CategoryService;
import com.ecommerce.pim.utils.mappers.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final MessageSource messageSource;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, MessageSource messageSource) {
        this.categoryRepository = categoryRepository;
        this.messageSource = messageSource;
    }

    @Override
    public Result getCategoryById(String id) {
        boolean businessRule = categoryRepository.existsCategoryByIdAndStatusAndLocked(Long.parseLong(id),'1','0');
        if (businessRule)
            return new SuccessDataResult<>(categoryRepository.findById(Long.parseLong(id)));
        return new ErrorDataResult(messageSource.getMessage(Constant.ERROR_ID, null, Locale.getDefault()));
    }

    @Override
    public Result getCategoryByCategoryTitle(String CategoryTitle) {
        boolean businessRule = categoryRepository.existsByCategoryTitleIgnoreCaseAndStatusAndLocked(CategoryTitle,'1','0');
        if (businessRule)
            return new SuccessDataResult<>(categoryRepository.findByCategoryTitle(CategoryTitle));
        return new ErrorDataResult(messageSource.getMessage(Constant.ERROR_CATEGORYTITLE, null, Locale.getDefault()));
    }

    @Override
    public DataResult<List<Category>> getCategoryByActive(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Category> categoryPage = categoryRepository.findActiveAll(pageable);
        if (!categoryPage.isEmpty() && categoryPage.toList().size() != 0)
            return new SuccessDataResult<>(categoryPage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Category>> getCategoryByNonActive(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Category> categoryPage = categoryRepository.findNonActiveAll(pageable);
        if (!categoryPage.isEmpty() && categoryPage.toList().size() != 0)
            return new SuccessDataResult<>(categoryPage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Category>> getAllCategoryofPage(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Category> categoryPage = categoryRepository.findAll(pageable);
        if (!categoryPage.isEmpty() && categoryPage.toList().size() != 0)
            return new SuccessDataResult<>(categoryPage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Category>> getAllCategoryofList() {
        List<Category> categorylist = categoryRepository.findAll();
        if (!categorylist.isEmpty() && categorylist.size() != 0)
            return new SuccessDataResult<>(categorylist);
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public Result createCategory(CreateCategoryRequestDto createCategoryRequestDto) {
        Category newCategory = CategoryMapper.categoryCreateMapper(createCategoryRequestDto);

        Result result = checkCategoryTitleIsAvailable(createCategoryRequestDto.getCategoryTitle());

        if (!result.isSuccess()) {
            return result;
        }

        categoryRepository.save(newCategory);
        return new SuccessResult();
    }

    @Override
    public Result updateCategory(String id, UpdateCategoryRequestDto updateCategoryRequestDto) {
        Category registeredCategory = categoryRepository.findByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');

        boolean i = categoryRepository.existsByCategoryTitleIgnoreCaseAndStatusAndLocked(updateCategoryRequestDto.getCategoryTitle(), '1', '0');
        boolean ii = registeredCategory.getCategoryTitle().equalsIgnoreCase(updateCategoryRequestDto.getCategoryTitle());

        if (!i) {
            updateSaveSuccess(updateCategoryRequestDto, registeredCategory);
            return new SuccessResult();
        } else {
            if (ii) {
                updateSaveSuccess(updateCategoryRequestDto, registeredCategory);
                return new SuccessResult();
            } else {
                return new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), "Bu başlığa sahip bir kategori vardır.");
            }
        }
    }

    @Override
    public Result updateActiveCategory(String id, UpdateActiveRequestDto updateActiveRequestDto) {
        Category registeredCategory = categoryRepository.findByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');

        boolean businessRules = registeredCategory != null;

        if (businessRules) {
            Category category = CategoryMapper.categoryUpdateActiveMapper(updateActiveRequestDto, registeredCategory);
            categoryRepository.save(category);
            return new SuccessResult();
        }

        return new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), messageSource.getMessage(Constant.ERROR_CATEGORYTITLE, null, Locale.getDefault()));
    }

    @Override
    public Result softDeleteCategoryById(String id) {
        Category registeredCategory = categoryRepository.findByIdAndStatusAndLocked(Long.parseLong(id),'1','0');
        boolean businessRules = registeredCategory != null;
        if (businessRules) {
            registeredCategory.setStatus('0');
            categoryRepository.save(registeredCategory);
            return new SuccessResult();
        }
        return new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Böyle bir nesne yok");
    }

    @Override
    public Result hardDeleteCategoryById(String id) {
        boolean businessRule = categoryRepository.existsById(Long.parseLong(id));
        if (businessRule) {
            categoryRepository.deleteById(Long.parseLong(id));
            return new SuccessResult();
        }
        return new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Böyle bir nesne yok");
    }

    @Override
    public Result softDeleteCategoryByCategoryTitle(String categoryTitle) {
        Category registeredCategory = categoryRepository.findByCategoryTitleAndStatusAndLocked(categoryTitle,'1','0');
        boolean businessRules = registeredCategory != null;
        if (businessRules) {
            registeredCategory.setStatus('0');
            categoryRepository.save(registeredCategory);
            return new SuccessResult();
        }
        return new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Böyle bir nesne yok");
    }

    @Override
    public Result hardDeleteCategoryByCategoryTitle(String categoryTitle) {
        boolean businessRule = categoryRepository.existsByCategoryTitleIgnoreCaseAndStatusAndLocked(categoryTitle,'1','0');
        if (businessRule) {
            categoryRepository.deleteByCategoryTitle(categoryTitle);
            return new SuccessResult();
        }
        return new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Böyle bir nesne yok");
    }

    private Result checkCategoryTitleIsAvailable(String categoryTitle) {
        boolean businessRule = categoryRepository.existsByCategoryTitleIgnoreCaseAndStatusAndLocked(categoryTitle,'1','0');
        if (businessRule) {
            return new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), "Bu başlığa sahip bir kategori vardır.");
        }
        return new SuccessResult();
    }

    private void updateSaveSuccess(UpdateCategoryRequestDto updateCategoryRequestDto, Category registeredCategorye) {
        Category updatedCategory = CategoryMapper.categoryUpdateMapper(updateCategoryRequestDto, registeredCategorye);
        categoryRepository.save(updatedCategory);
    }

}
