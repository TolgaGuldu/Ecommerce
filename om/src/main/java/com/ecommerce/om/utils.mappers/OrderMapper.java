package com.ecommerce.om.utils.mappers;

import com.ecommerce.om.dtos.create.CreateOrderRequestDto;
import com.ecommerce.om.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.om.dtos.update.UpdateOrderRequestDto;
import com.ecommerce.om.models.Order;

import java.util.Date;

public class OrderMapper {
    
    private OrderMapper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static Order orderCreateMapper(CreateOrderRequestDto createOrderRequestDto) {
        Order order = new Order();
        order.setProductIds(createOrderRequestDto.getProductIds());
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
        updatedorder.setProductIds(updateOrderRequestDto.getProductIds());
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


}
