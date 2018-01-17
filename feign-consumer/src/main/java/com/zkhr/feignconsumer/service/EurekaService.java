package com.zkhr.feignconsumer.service;

import com.zkhr.feignconsumer.config.DisableHystrixConfiguration2;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springboot-cloud-demo
 * @description: 根据服务的名称从eureka服务器上获取注册服务的信息
 * @author: DI CHENG
 * @create: 2018-01-17 16:39
 **/
@FeignClient(value = "xxxx", url = "http://localhost:1111/", configuration = DisableHystrixConfiguration2.class, fallback = EurekaServiceFallback.class)
public interface EurekaService {

    @RequestMapping(value = "/eureka/apps/{serviceName}")
    String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
