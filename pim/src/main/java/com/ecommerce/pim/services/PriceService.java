package com.ecommerce.pim.services;

import com.ecommerce.pim.common.results.DataResult;
import com.ecommerce.pim.common.results.Result;
import com.ecommerce.pim.dtos.create.CreatePriceRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdatePriceRequestDto;
import com.ecommerce.pim.models.Price;

import java.util.List;

public interface PriceService {
    Result getPriceById(String id);

    DataResult<List<Price>> getPriceByActive(int page, int limit, String type);

    DataResult<List<Price>> getPriceByNonActive(int page, int limit, String type);

    DataResult<List<Price>> getAllPriceofPage(int page, int limit, String type);

    DataResult<List<Price>> getAllPriceofList();

    Result createPrice(CreatePriceRequestDto createPriceRequestDto);

    Result updatePrice(String id, UpdatePriceRequestDto updatePriceRequestDto);

    Result updateActivePrice(String id, UpdateActiveRequestDto updateActiveRequestDto);

    Result softDeletePriceById(String id);

    Result hardDeletePriceById(String id);
}
