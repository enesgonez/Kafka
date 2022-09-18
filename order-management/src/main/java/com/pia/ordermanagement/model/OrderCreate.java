package com.pia.ordermanagement.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderCreate {

    private List<OrderItem> orderItems;

}
