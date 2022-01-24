package com.uniware.ecommerce.service;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKey;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

@Slf4j
public class JwtServiceTest {
    @Test
    public void test() {
        SecretKey secret = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(secret);
            oos.flush();

            String encodedKey = new String(Base64.getEncoder().encode(bos.toByteArray()));
            log.debug(encodedKey);
        } catch (IOException ex) {

        }
    }

    @Test
    public void testPassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        log.debug(encoder.encode("user01"));
    }


}
