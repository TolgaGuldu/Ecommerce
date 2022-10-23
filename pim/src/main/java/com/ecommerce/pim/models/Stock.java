package com.ecommerce.pim.models;

import com.ecommerce.pim.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock")
public class Stock extends BaseEntity {
    private int amount;

    private boolean available;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
