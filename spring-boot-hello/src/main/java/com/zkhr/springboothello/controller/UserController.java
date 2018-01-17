package com.zkhr.springboothello.controller;

import com.alibaba.fastjson.JSON;
import com.zkhr.springboothello.model.User;
import com.zkhr.springboothello.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

/**
 * @program: springboot-cloud-demo
 * @description: UserController
 * @author: DI CHENG
 * @create: 2018-01-17 10:07
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/findUserById", method = RequestMethod.GET)
    public User findUserById(@RequestParam("id") Integer id) {

        User user = userService.findUserById(id);
        logger.info("==根据id查询用户信息=="+JSON.toJSONString(user));
        return user;
    }

}
