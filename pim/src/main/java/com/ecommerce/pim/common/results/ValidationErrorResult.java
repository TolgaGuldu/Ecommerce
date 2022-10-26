package com.ecommerce.pim.common.results;

/**
 * Created on October 2022
 *
 * @author tolga
 */

public class ValidationErrorResult<T> extends DataResult<T> {

    public ValidationErrorResult(T message) {
        super(false,"203", message);
    }
}
