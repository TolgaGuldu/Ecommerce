package com.ecommerce.om.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Exception extends RuntimeException {

    private final Object[] arguments;

    private final HttpStatus status;

    public Exception(HttpStatus status, String reason) {
        super(reason);
        this.status = status;
        this.arguments = null;
    }

    /*public Exception(HttpStatus status, String reason, Object... args) {
        super(status, reason);
        this.arguments = args;
    }*/
}