package com.ecommerce.om.dtos.other;

import com.ecommerce.om.models.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private long id;

    private String productIds;

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
