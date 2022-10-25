package com.ecommerce.om.models;

import com.ecommerce.om.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created on 25 October, 2022
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

    @Column(name = "product_ids")
    private Long productIds;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "order_total_price")
    private double orderTotalPrice;

}
