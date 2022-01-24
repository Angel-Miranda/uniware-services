package com.uniware.ecommerce.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

//@Entity
@Getter
@Setter
public class Address implements Serializable {
    @Id
    private Long id;

    private String streetName;

    private String number;

    private String zipCode;

    private String city;

    private String state;

    private String notes;

    private Boolean isDefault;
}
