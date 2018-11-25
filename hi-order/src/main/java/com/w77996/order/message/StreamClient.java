package com.w77996.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {

    @Input("myMessage")
    SubscribableChannel inpt();

    @Output("myMessage")
    MessageChannel output();
}
