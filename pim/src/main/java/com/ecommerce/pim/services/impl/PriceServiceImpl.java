package com.ecommerce.pim.services.impl;

import com.ecommerce.pim.common.constants.Constant;
import com.ecommerce.pim.common.results.*;
import com.ecommerce.pim.dtos.create.CreatePriceRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdatePriceRequestDto;
import com.ecommerce.pim.models.Price;
import com.ecommerce.pim.repositories.PriceRepository;
import com.ecommerce.pim.services.PriceService;
import com.ecommerce.pim.utils.mappers.PriceMapper;
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
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;

    private final MessageSource messageSource;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository, MessageSource messageSource) {
        this.priceRepository = priceRepository;
        this.messageSource = messageSource;
    }

    @Override
    public Result getPriceById(String id) {
        boolean businessRule = priceRepository.existsPriceByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');
        if (businessRule)
            return new SuccessDataResult<>(priceRepository.findById(Long.parseLong(id)));
        return new ErrorDataResult(messageSource.getMessage(Constant.ERROR_ID, null, Locale.getDefault()));
    }

    @Override
    public DataResult<List<Price>> getPriceByActive(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Price> pricePage = priceRepository.findActiveAll(pageable);
        if (!pricePage.isEmpty() && pricePage.toList().size() != 0)
            return new SuccessDataResult<>(pricePage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Price>> getPriceByNonActive(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Price> pricePage = priceRepository.findNonActiveAll(pageable);
        if (!pricePage.isEmpty() && pricePage.toList().size() != 0)
            return new SuccessDataResult<>(pricePage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Price>> getAllPriceofPage(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Price> pricePage = priceRepository.findAll(pageable);
        if (!pricePage.isEmpty() && pricePage.toList().size() != 0)
            return new SuccessDataResult<>(pricePage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Price>> getAllPriceofList() {
        List<Price> pricelist = priceRepository.findAll();
        if (!pricelist.isEmpty() && pricelist.size() != 0)
            return new SuccessDataResult<>(pricelist);
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public Result createPrice(CreatePriceRequestDto createPriceRequestDto) {
        Price newPrice = PriceMapper.priceCreateMapper(createPriceRequestDto);
        priceRepository.save(newPrice);
        return new SuccessResult();
    }

    @Override
    public Result updatePrice(String id, UpdatePriceRequestDto updatePriceRequestDto) {
        Price registeredPrice = priceRepository.findByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');
        Price updatedPrice = PriceMapper.priceUpdateMapper(updatePriceRequestDto, registeredPrice);
        priceRepository.save(updatedPrice);
        return new SuccessResult();
    }

    @Override
    public Result updateActivePrice(String id, UpdateActiveRequestDto updateActiveRequestDto) {
        Price registeredPrice = priceRepository.findByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');

        boolean businessRules = registeredPrice != null;

        if (businessRules) {
            Price price = PriceMapper.priceUpdateActiveMapper(updateActiveRequestDto, registeredPrice);
            priceRepository.save(price);
            return new SuccessResult();
        }

        return new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), messageSource.getMessage(Constant.ERROR_CATEGORYTITLE, null, Locale.getDefault()));
    }


    @Override
    public Result softDeletePriceById(String id) {
        Price registeredPrice = priceRepository.findByIdAndStatusAndLocked(Long.parseLong(id),'1','0');
        boolean businessRules = registeredPrice != null;
        if (businessRules) {
            registeredPrice.setStatus('0');
            priceRepository.save(registeredPrice);
            return new SuccessResult();
        }
        return new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Böyle bir nesne yok");
    }

    @Override
    public Result hardDeletePriceById(String id) {
        boolean businessRule = priceRepository.existsById(Long.parseLong(id));
        if (businessRule) {
            priceRepository.deleteById(Long.parseLong(id));
            return new SuccessResult();
        }
        return new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Böyle bir nesne yok");
    }
}
