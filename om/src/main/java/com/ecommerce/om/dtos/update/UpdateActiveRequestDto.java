package com.ecommerce.om.dtos.update;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@Data
public class UpdateActiveRequestDto {
    @Max(1)
    @Min(0)
    @PositiveOrZero
    private String active;
}
