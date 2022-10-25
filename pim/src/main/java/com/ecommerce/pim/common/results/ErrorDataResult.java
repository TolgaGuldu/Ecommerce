package com.ecommerce.pim.common.results;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult(T message) {
        super(true,"205", message);
    }

}
