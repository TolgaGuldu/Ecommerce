package com.ecommerce.om.dtos.update;

import com.ecommerce.om.models.Address;
import lombok.Data;

import java.util.List;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

@Data
public class UpdateOrderRequestDto {

    private Long productIds;

    private Address address;

    private double orderTotalPrice;

}
