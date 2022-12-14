package com.ecommerce.pim.models;

import com.ecommerce.pim.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
@Table(name = "price")
public class Price extends BaseEntity {
    @Column(name = "price")
    private double price;

    @Column(name = "currency")
    private String currency;

}
