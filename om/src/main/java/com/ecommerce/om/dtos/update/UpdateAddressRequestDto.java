package com.ecommerce.om.dtos.update;

import com.ecommerce.om.models.Order;
import lombok.Data;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

@Data
public class UpdateAddressRequestDto {

    private Order order;

    private String description;

    private String address;

}
