package com.zkhr.ribbonconsumer.controller;

import com.zkhr.ribbonconsumer.model.User;
import com.zkhr.ribbonconsumer.service.IHelloService;
import com.zkhr.ribbonconsumer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dicheng on 17-12-20.
 */
@RestController
public class ConsumerController {

    @Autowired
    private IHelloService helloService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.helloConsumer();
    }

    @RequestMapping(value = "/findUserById",method = RequestMethod.GET)
    public User findUserById(@RequestParam("id") Integer id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/findUserById2",method = RequestMethod.GET)
    public User findUserById2(@RequestParam("id") Integer id) {
        return userService.findUserById2(id);
    }
}
