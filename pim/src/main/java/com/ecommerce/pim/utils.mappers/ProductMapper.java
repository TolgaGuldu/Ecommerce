package com.ecommerce.pim.utils.mappers;

import com.ecommerce.pim.dtos.create.CreateProductRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdateProductRequestDto;
import com.ecommerce.pim.models.Product;

import java.util.Date;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

public class ProductMapper {

    private ProductMapper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static Product productCreateMapper(CreateProductRequestDto createProductRequestDto){
        Product product = new Product();
        product.setName(createProductRequestDto.getName());
        product.setPictureUrl(createProductRequestDto.getPictureUrl());
        product.setDescription(createProductRequestDto.getDescription());
        product.setOrigin(createProductRequestDto.getOrigin());
        product.setHeight(createProductRequestDto.getHeight());
        product.setWeight(createProductRequestDto.getWeight());
        product.setCategory(createProductRequestDto.getCategory());
        product.setPrice(createProductRequestDto.getPrice());
        product.setStock(createProductRequestDto.getStock());
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
        updatedProduct.setName(updateProductRequestDto.getName());
        updatedProduct.setPictureUrl(updateProductRequestDto.getPictureUrl());
        updatedProduct.setDescription(updateProductRequestDto.getDescription());
        updatedProduct.setOrigin(updateProductRequestDto.getOrigin());
        updatedProduct.setHeight(updateProductRequestDto.getHeight());
        updatedProduct.setWeight(updateProductRequestDto.getWeight());
        updatedProduct.setCategory(updateProductRequestDto.getCategory());
        updatedProduct.setPrice(updateProductRequestDto.getPrice());
        updatedProduct.setStock(updateProductRequestDto.getStock());
        updatedProduct.setModifiedBy(0);
        updatedProduct.setModifiedDate(new Date());
        return updatedProduct;
    }

    public static Product productUpdateActiveMapper(UpdateActiveRequestDto updateActiveRequestDto, Product updatedProduct){
        updatedProduct.setActive(updateActiveRequestDto.getActive().charAt(0));
        return updatedProduct;
    }

}
