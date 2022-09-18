package com.pia.inventorymanagement.model.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order {
    private String id;
    private List<OrderItem> orderItems;
}
