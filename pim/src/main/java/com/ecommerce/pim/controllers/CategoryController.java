package com.ecommerce.pim.controllers;

import com.ecommerce.pim.dtos.create.CreateCategoryRequestDto;
import com.ecommerce.pim.dtos.update.UpdateCategoryRequestDto;
import com.ecommerce.pim.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @DeleteMapping("/softDelete")
    public ResponseEntity<?> softDeleteCategory(@RequestParam String id) {
        return ResponseEntity.ok(categoryService.softDeleteCategoryById(id));
    }

    @DeleteMapping("/hardDelete")
    public ResponseEntity<?> hardDeleteCategory(@RequestParam String id) {
        return ResponseEntity.ok(categoryService.hardDeleteCategoryById(id));
    }
}
