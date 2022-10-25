package com.ecommerce.pim.services.impl;

import com.ecommerce.pim.common.constants.Constant;
import com.ecommerce.pim.common.results.*;
import com.ecommerce.pim.dtos.create.CreateStockRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdateStockRequestDto;
import com.ecommerce.pim.models.Stock;
import com.ecommerce.pim.repositories.StockRepository;
import com.ecommerce.pim.services.StockService;
import com.ecommerce.pim.utils.mappers.StockMapper;
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

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    private final MessageSource messageSource;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository, MessageSource messageSource) {
        this.stockRepository = stockRepository;
        this.messageSource = messageSource;
    }

    @Override
    public Result getStockById(String id) {
        boolean businessRule = stockRepository.existsStockByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');
        if (businessRule)
            return new SuccessDataResult<>(stockRepository.findById(Long.parseLong(id)));
        return new ErrorDataResult(messageSource.getMessage(Constant.ERROR_ID, null, Locale.getDefault()));
    }

    @Override
    public DataResult<List<Stock>> getStockByActive(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Stock> stockPage = stockRepository.findActiveAll(pageable);
        if (!stockPage.isEmpty() && stockPage.toList().size() != 0)
            return new SuccessDataResult<>(stockPage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Stock>> getStockByNonActive(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Stock> stockPage = stockRepository.findNonActiveAll(pageable);
        if (!stockPage.isEmpty() && stockPage.toList().size() != 0)
            return new SuccessDataResult<>(stockPage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Stock>> getAllStockofPage(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Stock> stockPage = stockRepository.findAll(pageable);
        if (!stockPage.isEmpty() && stockPage.toList().size() != 0)
            return new SuccessDataResult<>(stockPage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Stock>> getAllStockofList() {
        List<Stock> stocklist = stockRepository.findAll();
        if (!stocklist.isEmpty() && stocklist.size() != 0)
            return new SuccessDataResult<>(stocklist);
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public Result createStock(CreateStockRequestDto createStockRequestDto) {
        Stock newStock = StockMapper.stockCreateMapper(createStockRequestDto);
        stockRepository.save(newStock);
        return new SuccessResult();
    }

    @Override
    public Result updateStock(String id, UpdateStockRequestDto updateStockRequestDto) {
        Stock registeredStock = stockRepository.findByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');
        Stock updatedStock = StockMapper.stockUpdateMapper(updateStockRequestDto, registeredStock);
        stockRepository.save(updatedStock);
        return new SuccessResult();
    }

    @Override
    public Result updateActiveStock(String id, UpdateActiveRequestDto updateActiveRequestDto) {
        Stock registeredStock = stockRepository.findByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');

        boolean businessRules = registeredStock != null;

        if (businessRules) {
            Stock stock = StockMapper.stockUpdateActiveMapper(updateActiveRequestDto, registeredStock);
            stockRepository.save(stock);
            return new SuccessResult();
        }

        return new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), messageSource.getMessage(Constant.ERROR_CATEGORYTITLE, null, Locale.getDefault()));
    }


    @Override
    public Result softDeleteStockById(String id) {
        Stock registeredStock = stockRepository.findByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');
        boolean businessRules = registeredStock != null;
        if (businessRules) {
            registeredStock.setStatus('0');
            stockRepository.save(registeredStock);
            return new SuccessResult();
        }
        return new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Böyle bir nesne yok");
    }

    @Override
    public Result hardDeleteStockById(String id) {
        boolean businessRule = stockRepository.existsById(Long.parseLong(id));
        if (businessRule) {
            stockRepository.deleteById(Long.parseLong(id));
            return new SuccessResult();
        }
        return new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Böyle bir nesne yok");
    }
}
