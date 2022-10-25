package com.ecommerce.om.dtos.create;

import com.ecommerce.om.models.Order;
import lombok.Data;

@Data
public class CreateAddressRequestDto {

    private Order order;

    private String description;

    private String address;

}
