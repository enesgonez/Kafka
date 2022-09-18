package com.pia.ordermanagement.service.impl;

import com.pia.ordermanagement.document.Order;
import com.pia.ordermanagement.model.OrderCreate;
import com.pia.ordermanagement.repository.OrderRepository;
import com.pia.ordermanagement.service.EventService;
import com.pia.ordermanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final EventService eventService;

    @Override
    public Order create(OrderCreate orderCreate) {
        Order order = new Order();
        BeanUtils.copyProperties(orderCreate, order);
        String id = UUID.randomUUID().toString();
        order.setId(id);
        order.setState("created");
        Order createdOrder = orderRepository.save(order);
        eventService.publishOrderCreateEvent(createdOrder);
        return createdOrder;
    }

    @Override
    public Order cancel(String orderId) {
        Order foundOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order could not been found"));
        foundOrder.setState("cancelled");
        Order cancelledOrder = orderRepository.save(foundOrder);
        eventService.publishOrderCancelEvent(orderId);
        return cancelledOrder;
    }
}
