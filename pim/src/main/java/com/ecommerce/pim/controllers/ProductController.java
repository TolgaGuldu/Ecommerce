package com.ecommerce.pim.controllers;

import com.ecommerce.pim.dtos.create.CreateProductRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdateProductRequestDto;
import com.ecommerce.pim.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getByProductId(@RequestParam Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable("id") Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/getByActive")
    public ResponseEntity<?> getProductByActive(@RequestParam(defaultValue = "1") int page,
                                                @RequestParam(defaultValue = "10") int limit,
                                                @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(productService.getProductByActive(page, limit, type));
    }

    @GetMapping("/getByNonActive")
    public ResponseEntity<?> getProductByNonActive(@RequestParam(defaultValue = "1") int page,
                                                   @RequestParam(defaultValue = "10") int limit,
                                                   @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(productService.getProductByNonActive(page, limit, type));
    }

    @GetMapping("/getAllPage")
    public ResponseEntity<?> getAllProductofPage(@RequestParam(defaultValue = "1") int page,
                                                 @RequestParam(defaultValue = "10") int limit,
                                                 @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(productService.getAllProductofPage(page, limit, type));
    }

    @GetMapping("/getAllList")
    public ResponseEntity<?> getAllProductofList() {
        return ResponseEntity.ok(productService.getAllProductofList());
    }


    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody CreateProductRequestDto createProductRequestDto) {
        return ResponseEntity.ok(productService.createProduct(createProductRequestDto));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestParam String id, @Valid @RequestBody UpdateProductRequestDto updateProductRequestDto) {
        return ResponseEntity.ok(productService.updateProduct(id, updateProductRequestDto));
    }

    @PutMapping("/updateActive")
    public ResponseEntity<?> updateActiveProduct(@RequestParam String id, @Valid @RequestBody UpdateActiveRequestDto updateProductRequestDto) {
        return ResponseEntity.ok(productService.updateActiveProduct(id, updateProductRequestDto));
    }

    @DeleteMapping("/softDeletebyId")
    public ResponseEntity<?> softDeleteProductById(@RequestParam String id) {
        return ResponseEntity.ok(productService.softDeleteProductById(id));
    }

    @DeleteMapping("/hardDeletebyId")
    public ResponseEntity<?> hardDeleteProductById(@RequestParam String id) {
        return ResponseEntity.ok(productService.hardDeleteProductById(id));
    }


}
