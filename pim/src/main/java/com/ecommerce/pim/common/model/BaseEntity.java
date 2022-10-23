package com.ecommerce.pim.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "added_by")
    private long addedBy;

    @Column(name = "added_date")
    private Date addedDate;

    @Column(name = "modified_by")
    private long modifiedBy;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "active")
    private boolean active;

    @JsonIgnore
    @Column(name = "locked")
    private boolean locked;

    @JsonIgnore
    @Column(name = "status")
    private boolean status;
}
