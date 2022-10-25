package com.ecommerce.om.services.impl;

import com.ecommerce.om.common.constants.Constant;
import com.ecommerce.om.common.results.*;
import com.ecommerce.om.dtos.create.CreateAddressRequestDto;
import com.ecommerce.om.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.om.dtos.update.UpdateAddressRequestDto;
import com.ecommerce.om.models.Address;
import com.ecommerce.om.repositories.AddressRepository;
import com.ecommerce.om.services.AddressService;
import com.ecommerce.om.utils.mappers.AddressMapper;
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
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final MessageSource messageSource;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, MessageSource messageSource) {
        this.addressRepository = addressRepository;
        this.messageSource = messageSource;
    }

    @Override
    public Result getAddressById(String id) {
        boolean businessRule = addressRepository.existsAddressByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');
        if (businessRule)
            return new SuccessDataResult<>(addressRepository.findById(Long.parseLong(id)));
        return new ErrorDataResult(messageSource.getMessage(Constant.ERROR_ID, null, Locale.getDefault()));
    }

    @Override
    public DataResult<List<Address>> getAddressByActive(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Address> addressPage = addressRepository.findActiveAll(pageable);
        if (!addressPage.isEmpty() && addressPage.toList().size() != 0)
            return new SuccessDataResult<>(addressPage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Address>> getAddressByNonActive(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Address> addressPage = addressRepository.findNonActiveAll(pageable);
        if (!addressPage.isEmpty() && addressPage.toList().size() != 0)
            return new SuccessDataResult<>(addressPage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Address>> getAllAddressofPage(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Address> addressPage = addressRepository.findAll(pageable);
        if (!addressPage.isEmpty() && addressPage.toList().size() != 0)
            return new SuccessDataResult<>(addressPage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Address>> getAllAddressofList() {
        List<Address> addresslist = addressRepository.findAll();
        if (!addresslist.isEmpty() && addresslist.size() != 0)
            return new SuccessDataResult<>(addresslist);
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public Result createAddress(CreateAddressRequestDto createAddressRequestDto) {
        Address newAddress = AddressMapper.addressCreateMapper(createAddressRequestDto);
        addressRepository.save(newAddress);
        return new SuccessResult();
    }

    @Override
    public Result updateAddress(String id, UpdateAddressRequestDto updateAddressRequestDto) {
        Address registeredAddress = addressRepository.findByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');
        Address updatedAddress = AddressMapper.addressUpdateMapper(updateAddressRequestDto, registeredAddress);
        addressRepository.save(updatedAddress);
        return new SuccessResult();
    }

    @Override
    public Result updateActiveAddress(String id, UpdateActiveRequestDto updateActiveRequestDto) {
        Address registeredAddress = addressRepository.findByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');

        boolean businessRules = registeredAddress != null;

        if (businessRules) {
            Address address = AddressMapper.addressUpdateActiveMapper(updateActiveRequestDto, registeredAddress);
            addressRepository.save(address);
            return new SuccessResult();
        }

        return new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), messageSource.getMessage(Constant.ERROR_CATEGORYTITLE, null, Locale.getDefault()));
    }


    @Override
    public Result softDeleteAddressById(String id) {
        Address registeredAddress = addressRepository.findByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');
        boolean businessRules = registeredAddress != null;
        if (businessRules) {
            registeredAddress.setStatus('0');
            addressRepository.save(registeredAddress);
            return new SuccessResult();
        }
        return new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Böyle bir nesne yok");
    }

    @Override
    public Result hardDeleteAddressById(String id) {
        boolean businessRule = addressRepository.existsById(Long.parseLong(id));
        if (businessRule) {
            addressRepository.deleteById(Long.parseLong(id));
            return new SuccessResult();
        }
        return new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Böyle bir nesne yok");
    }

}
