package com.pia.ordermanagement.document;

import com.pia.ordermanagement.model.OrderItem;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
public class Order {
    private String id;
    private List<OrderItem> orderItems;
    private String state;
}
