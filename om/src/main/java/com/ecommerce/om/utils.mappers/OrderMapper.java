package com.ecommerce.om.utils.mappers;

import com.ecommerce.om.dtos.create.CreateOrderRequestDto;
import com.ecommerce.om.dtos.other.OrderDto;
import com.ecommerce.om.dtos.other.ProductDto;
import com.ecommerce.om.dtos.other.ResponseDto;
import com.ecommerce.om.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.om.dtos.update.UpdateOrderRequestDto;
import com.ecommerce.om.models.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created on October 2022
 *
 * @author tolga
 */

public class OrderMapper {

    private static final RestTemplate restTemplate = new RestTemplate();
    
    private OrderMapper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static Order orderCreateMapper(CreateOrderRequestDto createOrderRequestDto) {
        Order order = new Order();
        order.setProductIds(createOrderRequestDto.getProductIds().toString().replace("[","").replace("]",""));
        order.setAddress(createOrderRequestDto.getAddress());
        order.setOrderTotalPrice(createOrderRequestDto.getOrderTotalPrice());
        order.setAddedBy(0);
        order.setAddedDate(new Date());
        order.setModifiedBy(0);
        order.setModifiedDate(new Date());
        order.setActive('1');
        order.setLocked('0');
        order.setStatus('1');
        return order;
    }

    public static Order orderUpdateMapper(UpdateOrderRequestDto updateOrderRequestDto, Order updatedorder) {
        updatedorder.setProductIds(updateOrderRequestDto.getProductIds().toString());
        updatedorder.setAddress(updateOrderRequestDto.getAddress());
        updatedorder.setOrderTotalPrice(updateOrderRequestDto.getOrderTotalPrice());
        updatedorder.setModifiedBy(0);
        updatedorder.setModifiedDate(new Date());
        return updatedorder;
    }

    public static Order orderUpdateActiveMapper(UpdateActiveRequestDto updateActiveRequestDto, Order updatedOrder) {
        updatedOrder.setActive(updateActiveRequestDto.getActive().charAt(0));
        return updatedOrder;
    }

    public static OrderDto mapToOrder(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setProductIds(order.getProductIds());
        orderDto.setAddress(order.getAddress());
        orderDto.setOrderTotalPrice(order.getOrderTotalPrice());
        orderDto.setAddedBy(order.getAddedBy());
        orderDto.setAddedDate(order.getAddedDate());
        orderDto.setModifiedBy(order.getModifiedBy());
        orderDto.setModifiedDate(order.getModifiedDate());
        orderDto.setActive(order.getActive());
        orderDto.setLocked(order.getLocked());
        orderDto.setStatus(order.getStatus());
        return orderDto;
    }

    public static ResponseDto mapToResponse(OrderDto orderDto, ResponseDto responseDto) {
        List<ProductDto> productDtoList = new ArrayList<>();

        String[] product = orderDto.getProductIds().split(",");
        for (int i = 0; i < product.length; i++) {
            ResponseEntity<ProductDto> responseEntity = restTemplate
                    .getForEntity("http://localhost:8081/product/" + product[i],
                            ProductDto.class);
            responseEntity.getBody().toString();
            ProductDto productDto = responseEntity.getBody();
            productDto.toString();
            productDtoList.add(productDto);
            productDtoList.toString();
        }
        responseDto.setOrderDto(orderDto);
        responseDto.setProductDto(productDtoList);

        return responseDto;
    }

    }
