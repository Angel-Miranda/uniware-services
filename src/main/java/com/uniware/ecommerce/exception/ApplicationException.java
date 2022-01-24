package com.uniware.ecommerce.exception;

import lombok.Getter;

@Getter
public abstract class ApplicationException extends RuntimeException {
    private static final String DEFAULT_CODE = "CODE-0001";

    protected final String code;

    public ApplicationException(String message) {
        this(DEFAULT_CODE, message);
    }

    public ApplicationException(String code, String message) {
        this(DEFAULT_CODE, message, null);
    }

    public ApplicationException(String message, Throwable ex) {
        this(DEFAULT_CODE, message, ex);
    }

    public ApplicationException(String code, String message, Throwable ex) {
        super(message, ex);
        this.code = code;
    }

}
