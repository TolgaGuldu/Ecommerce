package com.ecommerce.pim.common.results;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class DataResult<T> extends Result {

    private T message;

    public DataResult(boolean isStatus,String status, T message) {
        super(isStatus,status);
        this.message = message;
    }
}
