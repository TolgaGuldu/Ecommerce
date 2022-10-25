package com.ecommerce.om.controllers;

import com.ecommerce.om.dtos.create.CreateOrderRequestDto;
import com.ecommerce.om.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.om.dtos.update.UpdateOrderRequestDto;
import com.ecommerce.om.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/getById")
    public ResponseEntity<?> getByOrderId(@RequestParam String id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping("/getByActive")
    public ResponseEntity<?> getOrderByActive(@RequestParam(defaultValue = "1") int page,
                                              @RequestParam(defaultValue = "10") int limit,
                                              @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(orderService.getOrderByActive(page, limit, type));
    }

    @GetMapping("/getByNonActive")
    public ResponseEntity<?> getOrderByNonActive(@RequestParam(defaultValue = "1") int page,
                                                 @RequestParam(defaultValue = "10") int limit,
                                                 @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(orderService.getOrderByNonActive(page, limit, type));
    }

    @GetMapping("/getAllPage")
    public ResponseEntity<?> getAllOrderofPage(@RequestParam(defaultValue = "1") int page,
                                               @RequestParam(defaultValue = "10") int limit,
                                               @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(orderService.getAllOrderofPage(page, limit, type));
    }

    @GetMapping("/getAllList")
    public ResponseEntity<?> getAllOrderofList() {
        return ResponseEntity.ok(orderService.getAllOrderofList());
    }


    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@Valid @RequestBody CreateOrderRequestDto createOrderRequestDto) {
        return ResponseEntity.ok(orderService.createOrder(createOrderRequestDto));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateOrder(@RequestParam String id, @Valid @RequestBody UpdateOrderRequestDto updateOrderRequestDto) {
        return ResponseEntity.ok(orderService.updateOrder(id, updateOrderRequestDto));
    }

    @PutMapping("/updateActive")
    public ResponseEntity<?> updateActiveOrder(@RequestParam String id, @Valid @RequestBody UpdateActiveRequestDto updateOrderRequestDto) {
        return ResponseEntity.ok(orderService.updateActiveOrder(id, updateOrderRequestDto));
    }

    @DeleteMapping("/softDeletebyId")
    public ResponseEntity<?> softDeleteOrderById(@RequestParam String id) {
        return ResponseEntity.ok(orderService.softDeleteOrderById(id));
    }

    @DeleteMapping("/hardDeletebyId")
    public ResponseEntity<?> hardDeleteOrderById(@RequestParam String id) {
        return ResponseEntity.ok(orderService.hardDeleteOrderById(id));
    }

}
