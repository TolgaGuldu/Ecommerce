package com.ecommerce.pim.utils.mappers;

import com.ecommerce.pim.dtos.create.CreateProductRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdateProductRequestDto;
import com.ecommerce.pim.models.Product;

import java.util.Date;

public class ProductMapper {
    private ProductMapper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }
    public static Product productCreateMapper(CreateProductRequestDto createProductRequestDto){
        Product product = new Product();
        product.setAddedBy(0);
        product.setAddedDate(new Date());
        product.setModifiedBy(0);
        product.setModifiedDate(new Date());
        product.setActive('1');
        product.setLocked('0');
        product.setStatus('1');
        return product;
    }

    public static Product productUpdateMapper(UpdateProductRequestDto updateProductRequestDto, Product updatedProduct){
        updatedProduct.setModifiedBy(0);
        updatedProduct.setModifiedDate(new Date());
        return updatedProduct;
    }

    public static Product productUpdateActiveMapper(UpdateActiveRequestDto updateActiveRequestDto, Product updatedProduct){
        updatedProduct.setActive(updateActiveRequestDto.getActive().charAt(0));
        return updatedProduct;
    }
}
