package com.ecommerce.pim.common.results;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Result {

    @JsonIgnore
    private boolean isSuccess;

    private String status;

    public Result(boolean isSuccess,String status)
    {
        this.isSuccess=isSuccess;
        this.status = status;
    }
}
