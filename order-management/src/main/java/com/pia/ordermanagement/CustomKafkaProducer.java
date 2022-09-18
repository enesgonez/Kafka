package com.pia.ordermanagement;

import com.pia.ordermanagement.model.event.BaseEvent;
import com.pia.ordermanagement.model.event.OrderCreateEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomKafkaProducer {

    private final KafkaTemplate<String, BaseEvent> kafkaTemplate;

    public void publishEvent(BaseEvent baseEvent) {
        String topicName = baseEvent.getType();
        ListenableFuture<SendResult<String, BaseEvent>> future = kafkaTemplate.send(topicName, baseEvent);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, BaseEvent> result) {
                log.info("event publish success");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("event publish failed", ex);
            }
        });
    }

}
