package com.pia.ordermanagement.controller.impl;

import com.pia.ordermanagement.controller.OrderController;
import com.pia.ordermanagement.document.Order;
import com.pia.ordermanagement.model.OrderCreate;
import com.pia.ordermanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerImpl implements OrderController {

    private final OrderService orderService;

    @Override
    public ResponseEntity<Order> create(OrderCreate orderCreate) {
        Order createdOrder = orderService.create(orderCreate);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Order> cancel(String orderId) {
        Order cancelledOrder = orderService.cancel(orderId);
        return new ResponseEntity<>(cancelledOrder, HttpStatus.OK);
    }

}
