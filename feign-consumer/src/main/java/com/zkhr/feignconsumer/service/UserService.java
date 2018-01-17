package com.zkhr.feignconsumer.service;

import com.zkhr.feignconsumer.config.DisableHystrixConfiguration1;
import com.zkhr.feignconsumer.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: springboot-cloud-demo
 * @description: UserService
 * @author: DI CHENG
 * @create: 2018-01-17 15:32
 **/
@FeignClient(value = "hello-service", configuration = DisableHystrixConfiguration1.class, fallback = UserServiceFallback.class)
public interface UserService {

    @RequestMapping(value = "user/findUserById", method = RequestMethod.GET)
    User findUserById(@RequestParam("id") Integer id);

}
