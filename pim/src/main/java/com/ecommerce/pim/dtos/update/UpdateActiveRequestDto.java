package com.ecommerce.pim.dtos.update;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;

/**
 * Created on 25 October, 2022
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
