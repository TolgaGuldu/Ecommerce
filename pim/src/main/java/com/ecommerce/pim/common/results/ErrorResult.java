package com.ecommerce.pim.common.results;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorResult extends Result {

    private String message;

    public ErrorResult(String status, String message) {
        super(false,status);
        this.message = message;
    }
}
