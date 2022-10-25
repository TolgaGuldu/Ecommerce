package com.ecommerce.om.dtos.other;

import com.ecommerce.om.models.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

@Data
public class OrderDto {

    private long id;

    private Long productIds;

    private Address address;

    private double orderTotalPrice;

    private long addedBy;

    private Date addedDate;

    private long modifiedBy;

    private Date modifiedDate;

    private char active;

    @JsonIgnore
    private char locked;

    @JsonIgnore
    private char status;
}
