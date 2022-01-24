package com.uniware.ecommerce.service;

import com.uniware.ecommerce.model.dto.Token;
import io.jsonwebtoken.Claims;

public interface JwtService {
    Token generateToken(String user, String password);

    Token refresh(String token);

    Claims validateToken(String token);
}
