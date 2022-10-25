package com.ecommerce.om.dtos.update;

import com.ecommerce.om.models.Order;
import lombok.Data;

@Data
public class UpdateAddressRequestDto {

    private Order order;

    private String description;

    private String address;

}
