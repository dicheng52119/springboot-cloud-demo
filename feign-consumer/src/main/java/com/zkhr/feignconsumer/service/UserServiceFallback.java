package com.zkhr.feignconsumer.service;

import com.zkhr.feignconsumer.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: springboot-cloud-demo
 * @description: UserServiceFallback
 * @author: DI CHENG
 * @create: 2018-01-17 15:37
 **/
@Component
public class UserServiceFallback implements UserService {

    @Override
    public User findUserById(@RequestParam("id") Integer id) {
        User user = new User();
        user.setId(0);
        user.setName("hystrix 断路保护");
        return user;
    }
}
