package com.pia.inventorymanagement.service.impl;

import com.pia.inventorymanagement.document.Inventory;
import com.pia.inventorymanagement.model.event.OrderCancelEvent;
import com.pia.inventorymanagement.model.event.OrderCreateEvent;
import com.pia.inventorymanagement.repository.InventoryRepository;
import com.pia.inventorymanagement.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public void createInventory(OrderCreateEvent orderCreateEvent) {
        List<Inventory> inventoryList = new ArrayList<>();
        orderCreateEvent.getOrder().getOrderItems().forEach(orderItem -> {
            Inventory inventory = new Inventory();
            inventory.setId(UUID.randomUUID().toString());
            inventory.setOrderId(orderCreateEvent.getOrder().getId());
            inventory.setName(orderItem.getName());
            inventory.setState("active");
            inventoryList.add(inventory);
        });
        inventoryRepository.saveAll(inventoryList);
    }

    @Override
    public void cancel(OrderCancelEvent orderCancelEvent) {
        String orderId = orderCancelEvent.getOrderId();
        List<Inventory> foundOrders = inventoryRepository.findByOrderId(orderId);
        foundOrders.forEach(inventory -> inventory.setState("cancelled"));
        inventoryRepository.saveAll(foundOrders);
    }

}
