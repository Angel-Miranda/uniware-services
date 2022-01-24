package com.uniware.ecommerce.service.impl;

import com.uniware.ecommerce.exception.StoreAuthenticationException;
import com.uniware.ecommerce.exception.ResourceNotFoundException;
import com.uniware.ecommerce.model.dto.Role;
import com.uniware.ecommerce.model.dto.Token;
import com.uniware.ecommerce.model.dto.User;
import com.uniware.ecommerce.service.JwtService;
import com.uniware.ecommerce.service.UserService;
import com.uniware.ecommerce.util.Constant;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.time.Instant;
import java.util.*;

import static com.uniware.ecommerce.util.Constant.SecurityConstant.*;

@Slf4j
@Service
public class JwtServiceImpl implements JwtService {
    @Value("${jwt.algorithm}")
    private SignatureAlgorithm signatureAlgorithm;

    @Value("${jwt.secret.path}")
    private String secretPath;

    @Value("${jwt.duration}")
    private long duration;

    @Autowired
    private UserService userService;

    @Override
    public Token generateToken(String user, String password) {
        User userModel = userService.authenticate(user, password);

        return getToken(userModel);
    }

    private Token getToken(User userModel) {
        final long creationTime = Instant.now().toEpochMilli();
        final long expirationTime = creationTime + (duration * 1000);
        log.debug("Creation Time: {}, Expiration Time: {}", creationTime, expirationTime);


        Map map = new HashMap();
        map.put(AUTHORITIES, Arrays.asList(map(userModel.getRole())));

        Claims claims = new DefaultClaims(map)
                .setSubject(userModel.getUsername())
                .setExpiration(new Date(expirationTime));

        String token = Jwts.builder().setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setClaims(claims)
                .signWith(getKey()).compact();

        return Token.builder().token(token).build();
    }

    @Override
    public Token refresh(String token) {
        if (token == null || !token.startsWith(TOKEN_PREFIX)) {
            throw new StoreAuthenticationException(TOKEN_CODE, TOKEN_NO_PRESENT_MESSAGE);
        }

        String content = token.replace(TOKEN_PREFIX, "").trim();
        log.debug("The token is: {}", content);
        Claims claims = validateToken(content);

        User user = userService.findByUsername(claims.getSubject());
        return getToken(user);
    }

    @Override
    public Claims validateToken(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            throw new StoreAuthenticationException(e.getMessage());
        }
    }

    private String map(Role role) {
        if (role != null) {
            return ROLE_PREFIX + role.getDescription();
        }

        return ROLE_PREFIX + Constant.Role.DEFAULT;
    }

    private Key getKey() {
        byte[] apiKey = readSecret();

        return new SecretKeySpec(apiKey, signatureAlgorithm.getJcaName());
    }

    private byte[] readSecret() {
        try {
            URL url = JwtServiceImpl.class.getResource("/" + secretPath);

            return Base64.getDecoder().decode(Files.readAllBytes(Paths.get(url.toURI())));
        } catch (IOException | URISyntaxException ex) {
            throw new ResourceNotFoundException("Error");
        }
    }

}
