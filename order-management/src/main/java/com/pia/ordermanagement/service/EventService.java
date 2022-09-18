package com.pia.ordermanagement.service;

import com.pia.ordermanagement.document.Order;

public interface EventService {

    void publishOrderCreateEvent(Order createdOrder);

    void publishOrderCancelEvent(String orderId);

}
