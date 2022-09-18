package com.pia.ordermanagement.service;

import com.pia.ordermanagement.document.Order;
import com.pia.ordermanagement.model.OrderCreate;

public interface OrderService {

    Order create(OrderCreate orderCreate);

    Order cancel(String orderId);
}
