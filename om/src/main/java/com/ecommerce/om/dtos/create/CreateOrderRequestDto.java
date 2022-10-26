package com.ecommerce.om.dtos.create;

import com.ecommerce.om.models.Address;
import lombok.Data;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Set;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@Data
public class CreateOrderRequestDto {

    private List<@Positive String> productIds;

    private Address address;

    private double orderTotalPrice;

}
