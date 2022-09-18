package com.pia.ordermanagement.model.event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseEvent {
    private String type;
}
