package com.ecommerce.om.dtos.other;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private List<ProductDto> productDto;
    private OrderDto orderDto;
}
