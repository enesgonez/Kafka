package com.pia.ordermanagement.controller;

import com.pia.ordermanagement.document.Order;
import com.pia.ordermanagement.model.OrderCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderController {

    @PostMapping(value = "/order",
            produces = {"application/json;charset=utf-8"},
            consumes = {"application/json;charset=utf-8"}
    )
    ResponseEntity<Order> create(@RequestBody OrderCreate orderCreate);

    @DeleteMapping(value = "/order/{id}",
            produces = {"application/json;charset=utf-8"}
    )
    ResponseEntity<Order> cancel(@PathVariable("id") String orderId);

}
