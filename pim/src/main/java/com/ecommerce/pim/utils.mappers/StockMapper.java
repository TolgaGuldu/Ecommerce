package com.ecommerce.pim.utils.mappers;

import com.ecommerce.pim.dtos.create.CreateStockRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdateStockRequestDto;
import com.ecommerce.pim.models.Stock;

import java.util.Date;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

public class StockMapper {
    private StockMapper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }
    public static Stock stockCreateMapper(CreateStockRequestDto createStockRequestDto) {
        Stock stock = new Stock();
        stock.setAmount(createStockRequestDto.getAmount());
        stock.setAvailable(createStockRequestDto.getAvailable());
        stock.setProduct(createStockRequestDto.getProduct());
        stock.setAddedBy(0);
        stock.setAddedDate(new Date());
        stock.setModifiedBy(0);
        stock.setModifiedDate(new Date());
        stock.setActive('1');
        stock.setLocked('0');
        stock.setStatus('1');
        return stock;
    }

    public static Stock stockUpdateMapper(UpdateStockRequestDto updateStockRequestDto, Stock updatedStock) {
        updatedStock.setAmount(updatedStock.getAmount());
        updatedStock.setAvailable(updatedStock.getAvailable());
        updatedStock.setProduct(updatedStock.getProduct());
        updatedStock.setModifiedBy(0);
        updatedStock.setModifiedDate(new Date());
        return updatedStock;
    }

    public static Stock stockUpdateActiveMapper(UpdateActiveRequestDto updateActiveRequestDto, Stock updatedStock) {
        updatedStock.setActive(updateActiveRequestDto.getActive().charAt(0));
        return updatedStock;
    }
}
