package com.uniware.ecommerce.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;

//@Entity
@Getter
@Setter
public class PersonalInformation implements Serializable {
    @Id
    private Long id;

    @OneToOne
    private User user;

    private String firstName;

    private String lastName;

    //@OneToMany
    private List<Address> addresses;
}
