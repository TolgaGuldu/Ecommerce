package com.ecommerce.pim.services;

import com.ecommerce.pim.common.results.DataResult;
import com.ecommerce.pim.common.results.Result;
import com.ecommerce.pim.dtos.create.CreateStockRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdateStockRequestDto;
import com.ecommerce.pim.models.Stock;

import java.util.List;

/**
 * Created on October 2022
 *
 * @author tolga
 */

public interface StockService {
    Result getStockById(String id);

    DataResult<List<Stock>> getStockByActive(int page, int limit, String type);

    DataResult<List<Stock>> getStockByNonActive(int page, int limit, String type);

    DataResult<List<Stock>> getAllStockofPage(int page, int limit, String type);

    DataResult<List<Stock>> getAllStockofList();

    Result createStock(CreateStockRequestDto createStockRequestDto);

    Result updateStock(String id, UpdateStockRequestDto updateStockRequestDto);

    Result updateActiveStock(String id, UpdateActiveRequestDto updateActiveRequestDto);

    Result softDeleteStockById(String id);

    Result hardDeleteStockById(String id);
}
