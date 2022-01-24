package com.uniware.ecommerce.exception;

import lombok.Getter;

@Getter
public class StoreAuthenticationException extends ApplicationException {
    private static final String DEFAULT_CODE = "SEC-0001";

    public StoreAuthenticationException(String message) {
        this(DEFAULT_CODE, message);
    }

    public StoreAuthenticationException(String code, String message) {
        this(code, message, null);
    }

    public StoreAuthenticationException(String message, Throwable ex) {
        this(DEFAULT_CODE, message, ex);
    }

    public StoreAuthenticationException(String code, String message, Throwable ex) {
        super(code, message, ex);
    }
}

