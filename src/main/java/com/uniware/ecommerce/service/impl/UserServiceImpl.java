package com.uniware.ecommerce.service.impl;

import com.uniware.ecommerce.model.entity.UserEntity;
import com.uniware.ecommerce.exception.StoreAuthenticationException;
import com.uniware.ecommerce.model.dto.User;
import com.uniware.ecommerce.repository.UserEntityRepository;
import com.uniware.ecommerce.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.uniware.ecommerce.util.Constant.SecurityConstant.AUTHENTICATION_CODE;
import static com.uniware.ecommerce.util.Constant.SecurityConstant.USER_PASSWORD_MESSAGE;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserEntityRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User authenticate(String username, String password) {
        UserEntity userEntity = getUserEntity(username);

        if (!passwordEncoder.matches(password, userEntity.getPassword())) {
            throw new StoreAuthenticationException(AUTHENTICATION_CODE, USER_PASSWORD_MESSAGE);
        }

        return mapper.map(userEntity, User.class);
    }

    private UserEntity getUserEntity(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);

        if (userEntity == null) {
            throw new StoreAuthenticationException(AUTHENTICATION_CODE, USER_PASSWORD_MESSAGE);
        }

        return userEntity;

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
