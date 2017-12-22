package com.zkhr.ribbonconsumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zkhr.ribbonconsumer.service.IHelloService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by dicheng on 17-12-20.
 */
@Service
public class HelloService implements IHelloService {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "helloFallback", commandKey = "helloKey")
    public String helloConsumer() {
        long start = System.currentTimeMillis();

        //添加HystrixCommand注解来制定回调方法
        String result = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();

        long end = System.currentTimeMillis();

        logger.info("Spend time:"+(end - start));

        return result;
    }

    public String helloFallback() {
        return "error";
    }
}
