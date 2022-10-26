package com.ecommerce.pim.services.impl;

import com.ecommerce.pim.common.constants.Constant;
import com.ecommerce.pim.common.results.*;
import com.ecommerce.pim.dtos.create.CreateProductRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdatePriceRequestDto;
import com.ecommerce.pim.dtos.update.UpdateProductRequestDto;
import com.ecommerce.pim.dtos.update.UpdateStockRequestDto;
import com.ecommerce.pim.models.Category;
import com.ecommerce.pim.models.Price;
import com.ecommerce.pim.models.Product;
import com.ecommerce.pim.models.Stock;
import com.ecommerce.pim.repositories.CategoryRepository;
import com.ecommerce.pim.repositories.PriceRepository;
import com.ecommerce.pim.repositories.ProductRepository;
import com.ecommerce.pim.repositories.StockRepository;
import com.ecommerce.pim.services.PriceService;
import com.ecommerce.pim.services.ProductService;
import com.ecommerce.pim.services.StockService;
import com.ecommerce.pim.utils.mappers.CategoryMapper;
import com.ecommerce.pim.utils.mappers.PriceMapper;
import com.ecommerce.pim.utils.mappers.ProductMapper;
import com.ecommerce.pim.utils.mappers.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.Locale;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final PriceRepository priceRepository;

    private final CategoryRepository categoryRepository;

    private final StockRepository stockRepository;

    private final MessageSource messageSource;

    private final PriceService priceService;

    private final StockService stockService;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, PriceRepository priceRepository, CategoryRepository categoryRepository, StockRepository stockRepository, MessageSource messageSource, PriceService priceService, StockService stockService) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.categoryRepository = categoryRepository;
        this.stockRepository = stockRepository;
        this.messageSource = messageSource;
        this.priceService = priceService;
        this.stockService = stockService;
    }

    @Override
    public Result getProductById(long id) {
        boolean businessRule = productRepository.existsProductByIdAndStatusAndLocked(id, '1', '0');
        if (businessRule)
            return new SuccessDataResult<>(productRepository.findById(id));
        return new ErrorDataResult(messageSource.getMessage(Constant.ERROR_ID, null, Locale.getDefault()));
    }

    @Override
    public Product getProductByIdList(Long idList) {
        return productRepository.findById(idList).get();
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
    @Transient
    public Result createProduct(CreateProductRequestDto createProductRequestDto) {
        Product newProduct = ProductMapper.productCreateMapper(createProductRequestDto);
        if (createProductRequestDto.getPrice() != null) {
            Price price = PriceMapper.priceCreateMapper(createProductRequestDto.getPrice());
            priceRepository.save(price);
            newProduct.setPrice(price);
        }
        if (createProductRequestDto.getStock() != null) {
            Stock stock = StockMapper.stockCreateMapper(createProductRequestDto.getStock());
            stockRepository.save(stock);
            newProduct.setStock(stock);
        }

        if (createProductRequestDto.getCategory() != null) {
                if (!categoryRepository.existsByCategoryTitleIgnoreCaseAndStatusAndLocked(createProductRequestDto.getCategory().getCategoryTitle(),'1','0')) {
                    Category category = CategoryMapper.categoryCreateMapper(createProductRequestDto.getCategory());
                    categoryRepository.save(category);
                    newProduct.setCategory(category);
                }
                else {
                    Category category = CategoryMapper.categoryCreateMapper(createProductRequestDto.getCategory());
                    newProduct.setCategory(category);
                }
        }

        productRepository.save(newProduct);
        return new SuccessResult();
    }

    @Override
    public Result updateProduct(String id, UpdateProductRequestDto updateProductRequestDto) {
        Product registeredProduct = productRepository.findByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');
        if (updateProductRequestDto.getPrice() != null) {
            UpdatePriceRequestDto updatePriceRequestDto = new UpdatePriceRequestDto();
            updatePriceRequestDto.setPrice(updateProductRequestDto.getPrice());
            priceService.updatePrice(String.valueOf(registeredProduct.getPrice().getId()), updatePriceRequestDto);
        }
        if(updateProductRequestDto.getStock() != null) {
            UpdateStockRequestDto updateStockRequestDto = new UpdateStockRequestDto();
            updateStockRequestDto.setAmount(updateProductRequestDto.getStock());
            stockService.updateStock(String.valueOf(registeredProduct.getStock().getId()), updateStockRequestDto);
        }
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

        return new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), messageSource.getMessage(Constant.ERROR_ID, null, Locale.getDefault()));
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
