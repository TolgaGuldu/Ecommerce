package com.ecommerce.om.services;

import com.ecommerce.om.common.results.DataResult;
import com.ecommerce.om.common.results.Result;
import com.ecommerce.om.dtos.create.CreateOrderRequestDto;
import com.ecommerce.om.dtos.other.ResponseDto;
import com.ecommerce.om.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.om.dtos.update.UpdateOrderRequestDto;
import com.ecommerce.om.models.Order;

import java.util.List;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

public interface OrderService {

    ResponseDto getOrder(Long orderId);

    Result getOrderById(String id);

    DataResult<List<Order>> getOrderByActive(int page, int limit, String type);

    DataResult<List<Order>> getOrderByNonActive(int page, int limit, String type);

    DataResult<List<Order>> getAllOrderofPage(int page, int limit, String type);

    DataResult<List<Order>> getAllOrderofList();

    Result createOrder(CreateOrderRequestDto createOrderRequestDto);

    Result updateOrder(String id, UpdateOrderRequestDto updateOrderRequestDto);

    Result updateActiveOrder(String id, UpdateActiveRequestDto updateActiveRequestDto);

    Result softDeleteOrderById(String id);

    Result hardDeleteOrderById(String id);
}
