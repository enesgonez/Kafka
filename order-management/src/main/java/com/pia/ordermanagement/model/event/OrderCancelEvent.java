package com.pia.ordermanagement.model.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCancelEvent extends BaseEvent {

    private String orderId;

}
