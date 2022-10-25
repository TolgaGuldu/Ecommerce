package com.ecommerce.om.dtos.update;

import com.ecommerce.om.models.Address;
import lombok.Data;

@Data
public class UpdateOrderRequestDto {

    private Long[] productIds;

    private Address address;

    private double orderTotalPrice;

}
