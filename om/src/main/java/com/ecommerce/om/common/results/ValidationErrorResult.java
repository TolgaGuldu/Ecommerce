package com.ecommerce.om.common.results;

public class ValidationErrorResult<T> extends DataResult<T> {

    public ValidationErrorResult(T message) {
        super(false,"203", message);
    }
}
