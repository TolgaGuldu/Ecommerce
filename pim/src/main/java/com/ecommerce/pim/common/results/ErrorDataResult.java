package com.ecommerce.pim.common.results;

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult(T message) {
        super(true,"205", message);
    }

}
