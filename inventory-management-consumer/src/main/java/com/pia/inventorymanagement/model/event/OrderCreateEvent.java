package com.pia.inventorymanagement.model.event;

import com.pia.inventorymanagement.model.order.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreateEvent extends BaseEvent {

    private Order order;

}
