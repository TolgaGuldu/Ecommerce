package com.ecommerce.pim.services.impl;

import com.ecommerce.pim.common.constants.Constant;
import com.ecommerce.pim.common.results.*;
import com.ecommerce.pim.dtos.create.CreateProductRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdateProductRequestDto;
import com.ecommerce.pim.models.Product;
import com.ecommerce.pim.repositories.ProductRepository;
import com.ecommerce.pim.services.ProductService;
import com.ecommerce.pim.utils.mappers.ProductMapper;
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
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final MessageSource messageSource;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, MessageSource messageSource) {
        this.productRepository = productRepository;
        this.messageSource = messageSource;
    }

    @Override
    public Result getProductById(long id) {
        boolean businessRule = productRepository.existsProductByIdAndStatusAndLocked(id, '1', '0');
        if (businessRule)
            return new SuccessDataResult<>(productRepository.findById(id));
        return new ErrorDataResult(messageSource.getMessage(Constant.ERROR_ID, null, Locale.getDefault()));
    }

    @Override
    public DataResult<List<Product>> getProductByActive(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Product> productPage = productRepository.findActiveAll(pageable);
        if (!productPage.isEmpty() && productPage.toList().size() != 0)
            return new SuccessDataResult<>(productPage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Product>> getProductByNonActive(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Product> productPage = productRepository.findNonActiveAll(pageable);
        if (!productPage.isEmpty() && productPage.toList().size() != 0)
            return new SuccessDataResult<>(productPage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Product>> getAllProductofPage(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Product> productPage = productRepository.findAll(pageable);
        if (!productPage.isEmpty() && productPage.toList().size() != 0)
            return new SuccessDataResult<>(productPage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Product>> getAllProductofList() {
        List<Product> productlist = productRepository.findAll();
        if (!productlist.isEmpty() && productlist.size() != 0)
            return new SuccessDataResult<>(productlist);
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public Result createProduct(CreateProductRequestDto createProductRequestDto) {
        Product newProduct = ProductMapper.productCreateMapper(createProductRequestDto);
        productRepository.save(newProduct);
        return new SuccessResult();
    }

    @Override
    public Result updateProduct(String id, UpdateProductRequestDto updateProductRequestDto) {
        Product registeredProduct = productRepository.findByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');
        Product updatedProduct = ProductMapper.productUpdateMapper(updateProductRequestDto, registeredProduct);
        productRepository.save(updatedProduct);
        return new SuccessResult();
    }

    @Override
    public Result updateActiveProduct(String id, UpdateActiveRequestDto updateActiveRequestDto) {
        Product registeredProduct = productRepository.findByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');

        boolean businessRules = registeredProduct != null;

        if (businessRules) {
            Product product = ProductMapper.productUpdateActiveMapper(updateActiveRequestDto, registeredProduct);
            productRepository.save(product);
            return new SuccessResult();
        }

        return new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), messageSource.getMessage(Constant.ERROR_CATEGORYTITLE, null, Locale.getDefault()));
    }


    @Override
    public Result softDeleteProductById(String id) {
        Product registeredProduct = productRepository.findByIdAndStatusAndLocked(Long.parseLong(id),'1','0');
        boolean businessRules = registeredProduct != null;
        if (businessRules) {
            registeredProduct.setStatus('0');
            productRepository.save(registeredProduct);
            return new SuccessResult();
        }
        return new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Böyle bir nesne yok");
    }

    @Override
    public Result hardDeleteProductById(String id) {
        boolean businessRule = productRepository.existsById(Long.parseLong(id));
        if (businessRule) {
            productRepository.deleteById(Long.parseLong(id));
            return new SuccessResult();
        }
        return new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Böyle bir nesne yok");
    }
}
