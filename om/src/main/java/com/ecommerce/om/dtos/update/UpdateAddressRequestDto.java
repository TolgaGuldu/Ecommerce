package com.ecommerce.om.dtos.update;

import com.ecommerce.om.models.Order;
import lombok.Data;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@Data
public class UpdateAddressRequestDto {

    private String description;

    private String address;

}
