package com.ecommerce.om.dtos.create;

import com.ecommerce.om.models.Address;
import lombok.Data;

@Data
public class CreateOrderRequestDto {

    private Long[] productIds;

    private Address address;

    private double orderTotalPrice;

}
