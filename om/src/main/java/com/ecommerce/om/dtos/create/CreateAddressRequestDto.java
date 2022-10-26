package com.ecommerce.om.dtos.create;

import com.ecommerce.om.models.Order;
import lombok.Data;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@Data
public class CreateAddressRequestDto {

    private String description;

    private String address;

}
