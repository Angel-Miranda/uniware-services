package com.uniware.ecommerce.controller;

import com.uniware.ecommerce.model.dto.Token;
import com.uniware.ecommerce.model.dto.TokenRequest;
import com.uniware.ecommerce.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
    @Autowired
    private JwtService jwtService;

    @PostMapping("/auth/token")
    public Token getToken(@RequestBody TokenRequest user) {
        return jwtService.generateToken(user.getUsername(), user.getPassword());
    }
}
