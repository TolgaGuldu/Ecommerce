package com.ecommerce.pim.models;

import com.ecommerce.pim.common.model.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseEntity {
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "description")
    private String description;

   // @Enumerated(EnumType.STRING)
    @Column(name = "origin")
    private Origin origin;

    @Column(name = "height")
    private double height;

    @Column(name = "weight")
    private double weight;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne
    @JoinColumn(name = "price_id")
    private Price price;

    @OneToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;


}
