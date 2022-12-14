package com.ecommerce.om.models;

import com.ecommerce.om.common.model.BaseEntity;
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
@Table(name = "address_list")
public class Address extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

}
