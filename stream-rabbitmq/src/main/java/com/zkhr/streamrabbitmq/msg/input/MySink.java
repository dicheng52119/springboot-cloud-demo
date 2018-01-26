package com.zkhr.streamrabbitmq.msg.input;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @program: uxin-pay
 * @description:
 * @author: DI CHENG
 * @create: 2018-01-25 18:21
 **/
public interface MySink {

    String INPUT = "input";

    @Input(INPUT)
    MessageChannel input();
}
