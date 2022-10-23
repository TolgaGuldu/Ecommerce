package com.ecommerce.pim.common.results;

public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T message) {
        super(true,"200", message);
    }

}
