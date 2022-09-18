package com.pia.inventorymanagement.model.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCancelEvent extends BaseEvent {

    private String orderId;

}
