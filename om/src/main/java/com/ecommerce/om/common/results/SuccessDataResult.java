package com.ecommerce.om.common.results;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T message) {
        super(true,"200", message);
    }

}
