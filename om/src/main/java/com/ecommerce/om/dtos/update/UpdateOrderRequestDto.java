package com.ecommerce.om.dtos.update;

import com.ecommerce.om.models.Address;
import lombok.Data;

import javax.validation.constraints.Positive;
import java.util.List;


/**
 * Created on October 2022
 *
 * @author tolga
 */

@Data
public class UpdateOrderRequestDto {

    private List<@Positive String> productIds;

    private Address address;

    private double orderTotalPrice;

}
