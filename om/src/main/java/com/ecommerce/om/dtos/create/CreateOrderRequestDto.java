package com.ecommerce.om.dtos.create;

import com.ecommerce.om.models.Address;
import lombok.Data;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

@Data
public class CreateOrderRequestDto {

    private Long[] productIds;

    private Address address;

    private double orderTotalPrice;

}
