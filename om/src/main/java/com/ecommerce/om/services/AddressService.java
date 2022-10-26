package com.ecommerce.om.services;

import com.ecommerce.om.common.results.DataResult;
import com.ecommerce.om.common.results.Result;
import com.ecommerce.om.dtos.create.CreateAddressRequestDto;
import com.ecommerce.om.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.om.dtos.update.UpdateAddressRequestDto;
import com.ecommerce.om.models.Address;

import java.util.List;

/**
 * Created on October 2022
 *
 * @author tolga
 */

public interface AddressService {

    Result getAddressById(String id);

    DataResult<List<Address>> getAddressByActive(int page, int limit, String type);

    DataResult<List<Address>> getAddressByNonActive(int page, int limit, String type);

    DataResult<List<Address>> getAllAddressofPage(int page, int limit, String type);

    DataResult<List<Address>> getAllAddressofList();

    Result createAddress(CreateAddressRequestDto createAddressRequestDto);

    Result updateAddress(String id, UpdateAddressRequestDto updateAddressRequestDto);

    Result updateActiveAddress(String id, UpdateActiveRequestDto updateActiveRequestDto);

    Result softDeleteAddressById(String id);

    Result hardDeleteAddressById(String id);
}
