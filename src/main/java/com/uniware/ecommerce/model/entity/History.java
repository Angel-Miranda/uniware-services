package com.uniware.ecommerce.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class History implements Serializable {
    @Id
    private Long id;

    //private LocalDateTime data;

    //@ManyToOne
    //private User user;

    @ManyToOne
    private SaleStatus status;
}
