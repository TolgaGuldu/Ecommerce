package com.ecommerce.om.utils.mappers;

import com.ecommerce.om.dtos.create.CreateAddressRequestDto;
import com.ecommerce.om.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.om.dtos.update.UpdateAddressRequestDto;
import com.ecommerce.om.models.Address;

import java.util.Date;

public class AddressMapper {

    private AddressMapper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static Address addressCreateMapper(CreateAddressRequestDto createAddressRequestDto) {
        Address address = new Address();
        address.setOrder(createAddressRequestDto.getOrder());
        address.setDescription(createAddressRequestDto.getDescription());
        address.setAddress(createAddressRequestDto.getAddress());
        address.setAddedBy(0);
        address.setAddedDate(new Date());
        address.setModifiedBy(0);
        address.setModifiedDate(new Date());
        address.setActive('1');
        address.setLocked('0');
        address.setStatus('1');
        return address;
    }

    public static Address addressUpdateMapper(UpdateAddressRequestDto updateAddressRequestDto, Address updatedAddress) {
        updatedAddress.setOrder(updateAddressRequestDto.getOrder());
        updatedAddress.setDescription(updateAddressRequestDto.getDescription());
        updatedAddress.setAddress(updateAddressRequestDto.getAddress());
        updatedAddress.setModifiedBy(0);
        updatedAddress.setModifiedDate(new Date());
        return updatedAddress;
    }

    public static Address addressUpdateActiveMapper(UpdateActiveRequestDto updateActiveRequestDto, Address updatedAddress) {
        updatedAddress.setActive(updateActiveRequestDto.getActive().charAt(0));
        return updatedAddress;
    }

}
