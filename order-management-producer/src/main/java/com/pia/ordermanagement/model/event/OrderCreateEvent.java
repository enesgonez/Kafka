package com.pia.ordermanagement.model.event;

import com.pia.ordermanagement.document.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreateEvent extends BaseEvent {

    private Order order;

}
