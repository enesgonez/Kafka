package com.pia.ordermanagement.service.impl;

import com.pia.ordermanagement.CustomKafkaProducer;
import com.pia.ordermanagement.document.Order;
import com.pia.ordermanagement.model.event.OrderCancelEvent;
import com.pia.ordermanagement.model.event.OrderCreateEvent;
import com.pia.ordermanagement.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventServiceImpl implements EventService {

    private final CustomKafkaProducer customKafkaProducer;

    @Override
    public void publishOrderCreateEvent(Order createdOrder) {
        OrderCreateEvent orderCreateEvent = new OrderCreateEvent();
        orderCreateEvent.setType(OrderCreateEvent.class.getSimpleName());
        orderCreateEvent.setOrder(createdOrder);
        customKafkaProducer.publishEvent(orderCreateEvent);
    }

    @Override
    public void publishOrderCancelEvent(String orderId) {
        OrderCancelEvent orderCancelEvent = new OrderCancelEvent();
        orderCancelEvent.setType(OrderCancelEvent.class.getSimpleName());
        orderCancelEvent.setOrderId(orderId);
        customKafkaProducer.publishEvent(orderCancelEvent);
    }
}
