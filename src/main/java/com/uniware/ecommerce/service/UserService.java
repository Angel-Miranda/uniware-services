package com.uniware.ecommerce.service;

import com.uniware.ecommerce.model.dto.User;

public interface UserService {

    User authenticate(String username, String password);

    User findByUsername(String username);
}
