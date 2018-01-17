package com.zkhr.feignconsumer.service;

import com.zkhr.feignconsumer.model.User;
import feign.hystrix.FallbackFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-cloud-demo
 * @description: HelloServiceFallbackFactory 用于分析断路原因+处理断路回调逻辑
 * @author: DI CHENG
 * @create: 2018-01-17 17:35
 **/
@Component
public class HelloServiceFallbackFactory implements FallbackFactory<HelloService> {

    private static final Logger logger = Logger.getLogger(HelloServiceFallbackFactory.class);

    @Override
    public HelloService create(Throwable throwable) {

        //断路原因
        logger.info("fallback; reason was :" + throwable);

        //断路回调逻辑
        return new HelloServiceWithFactory() {
            @Override
            public String hello() {
                return "errorWithFactory";
            }

            @Override
            public String hello(String name) {
                return "errorWithFactory";
            }

            @Override
            public User hello(String name, Integer age) {
                User user = new User();
                user.setId(-1);
                return user;
            }

            @Override
            public String hello(User user) {
                return "errorWithFactory";
            }
        };
    }
}
