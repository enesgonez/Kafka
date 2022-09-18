package com.pia.inventorymanagement.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Inventory {

    private String id;
    private String orderId;
    private String name;
    private String state;

}
