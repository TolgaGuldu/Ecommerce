package com.ecommerce.pim.controllers;

import com.ecommerce.pim.dtos.create.CreateCategoryRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdateCategoryRequestDto;
import com.ecommerce.pim.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getByCategoryId(@RequestParam String id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping("/getByCategoryTitle")
    public ResponseEntity<?> getCategoryByCategoryTitle(@RequestParam String categoryTitle) {
        return ResponseEntity.ok(categoryService.getCategoryByCategoryTitle(categoryTitle));
    }

    @GetMapping("/getByActive")
    public ResponseEntity<?> getCategoryByActive(@RequestParam(defaultValue = "1") int page,
                                                        @RequestParam(defaultValue = "10") int limit,
                                                        @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(categoryService.getCategoryByActive(page, limit, type));
    }

    @GetMapping("/getByNonActive")
    public ResponseEntity<?> getCategoryByNonActive(@RequestParam(defaultValue = "1") int page,
                                                           @RequestParam(defaultValue = "10") int limit,
                                                           @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(categoryService.getCategoryByNonActive(page, limit, type));
    }

    @GetMapping("/getAllPage")
    public ResponseEntity<?> getAllCategoryofPage(@RequestParam(defaultValue = "1") int page,
                                             @RequestParam(defaultValue = "10") int limit,
                                             @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(categoryService.getAllCategoryofPage(page, limit, type));
    }

    @GetMapping("/getAllList")
    public ResponseEntity<?> getAllCategoryofList() {
        return ResponseEntity.ok(categoryService.getAllCategoryofList());
    }


    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CreateCategoryRequestDto createCategoryRequestDto) {
        return ResponseEntity.ok(categoryService.createCategory(createCategoryRequestDto));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCategory(@RequestParam String id, @Valid @RequestBody UpdateCategoryRequestDto updateCategoryRequestDto) {
        return ResponseEntity.ok(categoryService.updateCategory(id, updateCategoryRequestDto));
    }

    @PutMapping("/updateActive")
    public ResponseEntity<?> updateActiveCategory(@RequestParam String id,@Valid @RequestBody UpdateActiveRequestDto updateCategoryRequestDto) {
        return ResponseEntity.ok(categoryService.updateActiveCategory(id,updateCategoryRequestDto));
    }

    @DeleteMapping("/softDeletebyId")
    public ResponseEntity<?> softDeleteCategoryById(@RequestParam String id) {
        return ResponseEntity.ok(categoryService.softDeleteCategoryById(id));
    }

    @DeleteMapping("/hardDeletebyId")
    public ResponseEntity<?> hardDeleteCategoryById(@RequestParam String id) {
        return ResponseEntity.ok(categoryService.hardDeleteCategoryById(id));
    }

    @DeleteMapping("/softDeletebyCategoryTitle")
    public ResponseEntity<?> softDeleteCategoryByCategoryTitle(@RequestParam String categoryTitle) {
        return ResponseEntity.ok(categoryService.softDeleteCategoryByCategoryTitle(categoryTitle));
    }

    @DeleteMapping("/hardDeletebyCategoryTitle")
    public ResponseEntity<?> hardDeleteCategoryByCategoryTitle(@RequestParam String categoryTitle) {
        return ResponseEntity.ok(categoryService.hardDeleteCategoryByCategoryTitle(categoryTitle));
    }
}
