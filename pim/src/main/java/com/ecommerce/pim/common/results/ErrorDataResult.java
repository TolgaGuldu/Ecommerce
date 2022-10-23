package com.ecommerce.pim.common.results;

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult(T message) {
        super(true,"205", message);
    }

    public ErrorDataResult(boolean b, String message, String message1) {
    }

    public ErrorDataResult(String message, String message1) {
    }
}
