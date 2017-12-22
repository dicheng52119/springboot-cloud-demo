package com.zkhr.ribbonconsumer.controller;

import com.zkhr.ribbonconsumer.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dicheng on 17-12-20.
 */
@RestController
public class ConsumerController {

    @Autowired
    private IHelloService helloService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.helloConsumer();
    }
}
