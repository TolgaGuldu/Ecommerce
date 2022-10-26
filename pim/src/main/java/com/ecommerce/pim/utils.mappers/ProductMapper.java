package com.ecommerce.pim.utils.mappers;

import com.ecommerce.pim.dtos.create.CreateProductRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdateProductRequestDto;
import com.ecommerce.pim.models.Product;

import java.util.Date;

/**
 * Created on October 2022
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
        if(updateProductRequestDto.getName() != null)
            updatedProduct.setName(updateProductRequestDto.getName());
        if(updateProductRequestDto.getPictureUrl() != null)
            updatedProduct.setPictureUrl(updateProductRequestDto.getPictureUrl());
        if(updateProductRequestDto.getDescription() != null)
            updatedProduct.setDescription(updateProductRequestDto.getDescription());
        if(updateProductRequestDto.getOrigin() != null)
            updatedProduct.setOrigin(updateProductRequestDto.getOrigin());
        if(updateProductRequestDto.getHeight() != null)
            updatedProduct.setHeight(updateProductRequestDto.getHeight());
        if(updateProductRequestDto.getWeight() != null)
            updatedProduct.setWeight(updateProductRequestDto.getWeight());
        if(updateProductRequestDto.getCategoryid() != null)
            updatedProduct.getCategory().setId(updateProductRequestDto.getCategoryid());
        updatedProduct.setModifiedBy(0);
        updatedProduct.setModifiedDate(new Date());
        return updatedProduct;
    }

    public static Product productUpdateActiveMapper(UpdateActiveRequestDto updateActiveRequestDto, Product updatedProduct){
        updatedProduct.setActive(updateActiveRequestDto.getActive().charAt(0));
        return updatedProduct;
    }

}
