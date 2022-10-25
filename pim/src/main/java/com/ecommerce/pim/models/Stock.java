package com.ecommerce.pim.models;

import com.ecommerce.pim.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock")
public class Stock extends BaseEntity {
    @Column(name = "amount")
    private int amount;

    @Column(name = "available")
    private Boolean available;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
