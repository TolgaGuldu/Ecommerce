package com.ecommerce.om.common.results;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

public class ValidationErrorResult<T> extends DataResult<T> {

    public ValidationErrorResult(T message) {
        super(false,"203", message);
    }
}
