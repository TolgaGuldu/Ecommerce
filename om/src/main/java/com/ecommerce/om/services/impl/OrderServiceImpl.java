package com.ecommerce.om.services.impl;

import com.ecommerce.om.common.constants.Constant;
import com.ecommerce.om.common.results.*;
import com.ecommerce.om.dtos.create.CreateOrderRequestDto;
import com.ecommerce.om.dtos.other.OrderDto;
import com.ecommerce.om.dtos.other.ProductDto;
import com.ecommerce.om.dtos.other.ResponseDto;
import com.ecommerce.om.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.om.dtos.update.UpdateOrderRequestDto;
import com.ecommerce.om.models.Order;
import com.ecommerce.om.repositories.OrderRepository;
import com.ecommerce.om.services.OrderService;
import com.ecommerce.om.utils.mappers.OrderMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Locale;

/**
 * Created on October 2022
 *
 * @author tolga
 */



@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final MessageSource messageSource;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, MessageSource messageSource) {
        this.orderRepository = orderRepository;
        this.messageSource = messageSource;
    }

    @Override
    public Result getOrder(Long id, ResponseDto responseDto) {
        boolean businessRule = orderRepository.existsOrderByIdAndStatusAndLocked(id, '1', '0');
        if (businessRule) {
            Order order = orderRepository.findById(id).get();
            responseDto = OrderMapper.mapToResponse(OrderMapper.mapToOrder(order), responseDto);
            return new SuccessDataResult<>(responseDto);
        }
        return new ErrorDataResult(messageSource.getMessage(Constant.ERROR_ID, null, Locale.getDefault()));
    }

    @Override
    public Result getOrderById(String id) {
        boolean businessRule = orderRepository.existsOrderByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');
        if (businessRule)
            return new SuccessDataResult<>(orderRepository.findById(Long.parseLong(id)));
        return new ErrorDataResult(messageSource.getMessage(Constant.ERROR_ID, null, Locale.getDefault()));
    }

    @Override
    public DataResult<List<Order>> getOrderByActive(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Order> orderPage = orderRepository.findActiveAll(pageable);
        if (!orderPage.isEmpty() && orderPage.toList().size() != 0)
            return new SuccessDataResult<>(orderPage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Order>> getOrderByNonActive(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Order> orderPage = orderRepository.findNonActiveAll(pageable);
        if (!orderPage.isEmpty() && orderPage.toList().size() != 0)
            return new SuccessDataResult<>(orderPage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Order>> getAllOrderofPage(int page, int limit, String type) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(type));
        Page<Order> orderPage = orderRepository.findAll(pageable);
        if (!orderPage.isEmpty() && orderPage.toList().size() != 0)
            return new SuccessDataResult<>(orderPage.toList());
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public DataResult<List<Order>> getAllOrderofList() {
        List<Order> orderlist = orderRepository.findAll();
        if (!orderlist.isEmpty() && orderlist.size() != 0)
            return new SuccessDataResult<>(orderlist);
        return new ErrorDataResult("hiç birşey bulunamadı");
    }

    @Override
    public Result createOrder(CreateOrderRequestDto createOrderRequestDto) {
        Order newOrder = OrderMapper.orderCreateMapper(createOrderRequestDto);
        orderRepository.save(newOrder);
        return new SuccessResult();
    }

    @Override
    public Result updateOrder(String id, UpdateOrderRequestDto updateOrderRequestDto) {
        Order registeredOrder = orderRepository.findByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');
        Order updatedOrder = OrderMapper.orderUpdateMapper(updateOrderRequestDto, registeredOrder);
        orderRepository.save(updatedOrder);
        return new SuccessResult();
    }

    @Override
    public Result updateActiveOrder(String id, UpdateActiveRequestDto updateActiveRequestDto) {
        Order registeredOrder = orderRepository.findByIdAndStatusAndLocked(Long.parseLong(id), '1', '0');

        boolean businessRules = registeredOrder != null;

        if (businessRules) {
            Order order = OrderMapper.orderUpdateActiveMapper(updateActiveRequestDto, registeredOrder);
            orderRepository.save(order);
            return new SuccessResult();
        }

        return new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), messageSource.getMessage(Constant.ERROR_ID, null, Locale.getDefault()));
    }


    @Override
    public Result softDeleteOrderById(String id) {
        Order registeredOrder = orderRepository.findByIdAndStatusAndLocked(Long.parseLong(id),'1','0');
        boolean businessRules = registeredOrder != null;
        if (businessRules) {
            registeredOrder.setStatus('0');
            orderRepository.save(registeredOrder);
            return new SuccessResult();
        }
        return new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Böyle bir nesne yok");
    }

    @Override
    public Result hardDeleteOrderById(String id) {
        boolean businessRule = orderRepository.existsById(Long.parseLong(id));
        if (businessRule) {
            orderRepository.deleteById(Long.parseLong(id));
            return new SuccessResult();
        }
        return new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Böyle bir nesne yok");
    }


}
