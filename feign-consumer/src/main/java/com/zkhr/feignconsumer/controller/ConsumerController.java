package com.zkhr.feignconsumer.controller;

import com.zkhr.feignconsumer.model.User;
import com.zkhr.feignconsumer.service.EurekaService;
import com.zkhr.feignconsumer.service.HelloService;
import com.zkhr.feignconsumer.service.RefactorHelloService;
import com.zkhr.feignconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dicheng on 17-12-21.
 */
@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RefactorHelloService refactorHelloService;

    @Autowired
    private UserService userService;

    @Autowired
    private EurekaService eurekaService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append("普通无参请求:");
        sb.append(helloService.hello()).append("====请求参数请求:");
        sb.append(helloService.hello("DIDI")).append("====请求头请求:");
        sb.append(helloService.hello("DIDI",30)).append("====请求体请求:");
        sb.append(helloService.hello(new User("DIDI",30))).append("====");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
        sb.append("继承属性之普通无参请求:");
        sb.append(helloService.hello()).append("====继承属性之请求参数请求:");
        sb.append(helloService.hello("MIMI")).append("====继承属性之请求头请求:");
        sb.append(helloService.hello("MIMI",20)).append("====继承属性之请求体请求:");
        sb.append(helloService.hello(new User("MIMI",20))).append("====");
        return sb.toString();
    }

    @RequestMapping(value = "/findUserById", method = RequestMethod.GET)
    public User findUserById(@RequestParam("id") Integer id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/findServiceInfoFromEurekaByServiceName/{serviceName}", method = RequestMethod.GET)
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName) {
        return eurekaService.findServiceInfoFromEurekaByServiceName(serviceName);
    }


}
