package com.ecommerce.pim.services;

import com.ecommerce.pim.common.results.DataResult;
import com.ecommerce.pim.common.results.Result;
import com.ecommerce.pim.dtos.create.CreateProductRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdateProductRequestDto;
import com.ecommerce.pim.models.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on October 2022
 *
 * @author tolga
 */

public interface ProductService {
    Result getProductById(long id);

    Product getProductByIdList(Long idList);

    DataResult<List<Product>> getProductByActive(int page, int limit, String type);

    DataResult<List<Product>> getProductByNonActive(int page, int limit, String type);

    DataResult<List<Product>> getAllProductofPage(int page, int limit, String type);

    DataResult<List<Product>> getAllProductofList();

    Result createProduct(CreateProductRequestDto createProductRequestDto);

    Result updateProduct(String id, UpdateProductRequestDto updateProductRequestDto);

    Result updateActiveProduct(String id, UpdateActiveRequestDto updateActiveRequestDto);

    Result softDeleteProductById(String id);

    Result hardDeleteProductById(String id);
}
