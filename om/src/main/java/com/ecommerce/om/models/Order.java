package com.ecommerce.om.models;

import com.ecommerce.om.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_list")
public class Order extends BaseEntity {
    //@Basic
    @Column(name = "product_ids")
    private String productIds;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "order_total_price")
    private double orderTotalPrice;

}
