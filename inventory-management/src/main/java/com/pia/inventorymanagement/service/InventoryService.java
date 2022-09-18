package com.pia.inventorymanagement.service;

import com.pia.inventorymanagement.model.event.OrderCancelEvent;
import com.pia.inventorymanagement.model.event.OrderCreateEvent;

public interface InventoryService {

    void createInventory(OrderCreateEvent orderCreateEvent);

    void cancel(OrderCancelEvent orderCancelEvent);

}
