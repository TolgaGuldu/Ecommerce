package com.ecommerce.pim.common.results;

/**
 * Created on October 2022
 *
 * @author tolga
 */

public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T message) {
        super(true,"200", message);
    }

}
