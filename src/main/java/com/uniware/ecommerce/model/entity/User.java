package com.uniware.ecommerce.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

//@Entity
@Getter
@Setter
public class User implements Serializable {
    @Id
    private Long id;

    private String email;

    private String password;
}
