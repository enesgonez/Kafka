package com.pia.inventorymanagement;

import com.pia.inventorymanagement.model.event.OrderCancelEvent;
import com.pia.inventorymanagement.model.event.OrderCreateEvent;
import com.pia.inventorymanagement.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomKafkaConsumer {

    private final InventoryService inventoryService;

    @KafkaListener(topics = {"OrderCreateEvent"}, autoStartup = "true", containerFactory = "orderCreateEventKafkaListenerContainerFactory")
    public void orderCreateEventListener(@Payload OrderCreateEvent orderCreateEvent) {
        inventoryService.createInventory(orderCreateEvent);
    }

    @KafkaListener(topics = {"OrderCancelEvent"}, autoStartup = "true", containerFactory = "orderCancelEventKafkaListenerContainerFactory")
    public void orderCancelEventListener(@Payload OrderCancelEvent orderCancelEvent) {
        inventoryService.cancel(orderCancelEvent);
    }

}
