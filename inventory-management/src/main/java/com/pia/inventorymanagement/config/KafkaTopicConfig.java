package com.pia.inventorymanagement.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class KafkaTopicConfig {

    private final KafkaProperties kafkaProperties;

    @Bean(name = "topicList")
    public List<String> topicList() {
        return kafkaProperties.getTopics();
    }

}
