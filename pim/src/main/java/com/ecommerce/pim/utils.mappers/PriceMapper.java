package com.ecommerce.pim.utils.mappers;

import com.ecommerce.pim.dtos.create.CreatePriceRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdatePriceRequestDto;
import com.ecommerce.pim.models.Price;

import java.util.Date;

/**
 * Created on October 2022
 *
 * @author tolga
 */

public class PriceMapper {
    private PriceMapper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }
    public static Price priceCreateMapper(CreatePriceRequestDto createPriceRequestDto) {
        Price price = new Price();
        price.setPrice(createPriceRequestDto.getPrice());
        price.setCurrency(createPriceRequestDto.getCurrency());
        price.setAddedBy(0);
        price.setAddedDate(new Date());
        price.setModifiedBy(0);
        price.setModifiedDate(new Date());
        price.setActive('1');
        price.setLocked('0');
        price.setStatus('1');
        return price;
    }

    public static Price priceUpdateMapper(UpdatePriceRequestDto updatePriceRequestDto, Price updatedPrice) {
        updatedPrice.setPrice(updatePriceRequestDto.getPrice());
        updatedPrice.setCurrency(updatePriceRequestDto.getCurrency());
        updatedPrice.setModifiedBy(0);
        updatedPrice.setModifiedDate(new Date());
        return updatedPrice;
    }

    public static Price priceUpdateActiveMapper(UpdateActiveRequestDto updateActiveRequestDto, Price updatedPrice) {
        updatedPrice.setActive(updateActiveRequestDto.getActive().charAt(0));
        return updatedPrice;
    }
}
