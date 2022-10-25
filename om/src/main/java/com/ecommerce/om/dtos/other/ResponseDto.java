package com.ecommerce.om.dtos.other;

import com.ecommerce.om.dtos.create.CreateOrderRequestDto;
import lombok.Data;

@Data
public class ResponseDto {
    private ProductDto productDto;
    private OrderDto orderDto;
}
