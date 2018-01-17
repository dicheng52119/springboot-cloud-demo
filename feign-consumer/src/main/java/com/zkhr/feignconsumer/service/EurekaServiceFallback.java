package com.zkhr.feignconsumer.service;

import org.springframework.stereotype.Component;

/**
 * @program: springboot-cloud-demo
 * @description: EurekaServiceFallback
 * @author: DI CHENG
 * @create: 2018-01-17 16:46
 **/
@Component
public class EurekaServiceFallback implements EurekaService {

    @Override
    public String findServiceInfoFromEurekaByServiceName(String serviceName) {
        return "sorry, error is happing!";
    }
}
