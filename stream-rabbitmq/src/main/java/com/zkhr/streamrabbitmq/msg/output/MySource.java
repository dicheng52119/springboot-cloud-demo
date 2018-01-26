package com.zkhr.streamrabbitmq.msg.output;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @program: uxin-pay
 * @description:
 * @author: DI CHENG
 * @create: 2018-01-25 18:23
 **/
public interface MySource {

    String OUTPUT = "output";

    @Output(MySource.OUTPUT)
    MessageChannel output();

}
