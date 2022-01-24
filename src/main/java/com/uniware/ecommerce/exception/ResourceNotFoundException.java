package com.uniware.ecommerce.exception;

public class ResourceNotFoundException extends ApplicationException {
    private static final String DEFAULT_CODE = "WEB-0001";

    public ResourceNotFoundException(String message) {
        this(DEFAULT_CODE, message);
    }

    public ResourceNotFoundException(String code, String message) {
        this(code, message, null);
    }

    public ResourceNotFoundException(String message, Throwable ex) {
        this(DEFAULT_CODE, message, ex);
    }

    public ResourceNotFoundException(String code, String message, Throwable ex) {
        super(code, message, ex);
    }
}

