package com.pia.inventorymanagement.config;

import com.pia.inventorymanagement.model.event.BaseEvent;
import com.pia.inventorymanagement.model.event.OrderCancelEvent;
import com.pia.inventorymanagement.model.event.OrderCreateEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaConsumerConfig {

    private final KafkaProperties kafkaProperties;

    public ConsumerFactory<String, OrderCreateEvent> orderCreateEventConsumerFactory() {
        JsonDeserializer<OrderCreateEvent> deserializer = new JsonDeserializer<>(OrderCreateEvent.class);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeHeaders(false);
        deserializer.setRemoveTypeHeaders(true);
        return new DefaultKafkaConsumerFactory<>(getProperties(), new StringDeserializer(), deserializer);
    }

    public ConsumerFactory<String, OrderCancelEvent> orderCancelEventConsumerFactory() {
        JsonDeserializer<OrderCancelEvent> deserializer = new JsonDeserializer<>(OrderCancelEvent.class);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeHeaders(false);
        deserializer.setRemoveTypeHeaders(true);
        return new DefaultKafkaConsumerFactory<>(getProperties(), new StringDeserializer(), deserializer);
    }

    private Map<String, Object> getProperties(){
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getConsumer().getBootstrapServers());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "groupId");
        return props;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OrderCreateEvent> orderCreateEventKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, OrderCreateEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(orderCreateEventConsumerFactory());
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OrderCancelEvent> orderCancelEventKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, OrderCancelEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(orderCancelEventConsumerFactory());
        return factory;
    }
}