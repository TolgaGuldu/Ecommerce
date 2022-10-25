package com.ecommerce.om.common.results;

public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T message) {
        super(true,"200", message);
    }

}
