package com.uniware.ecommerce.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenRequest implements Serializable {
    private String username;
    private String password;
}
