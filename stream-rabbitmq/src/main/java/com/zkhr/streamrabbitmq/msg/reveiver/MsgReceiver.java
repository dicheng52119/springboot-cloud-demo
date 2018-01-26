package com.zkhr.streamrabbitmq.msg.reveiver;

import com.zkhr.streamrabbitmq.msg.input.MySink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * @program: uxin-pay
 * @description:
 * @author: DI CHENG
 * @create: 2018-01-26 10:11
 **/
@EnableBinding(value = {MySink.class})
public class MsgReceiver {

    private final Logger logger = LoggerFactory.getLogger(MsgReceiver.class);

    @StreamListener(MySink.INPUT)
    public void receive(Message<String> str) {
        logger.info("Received:" + str);
    }
}
