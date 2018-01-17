package com.zkhr.springboothello.service;

import com.zkhr.springboothello.model.User;

/**
 * @program: springboot-cloud-demo
 * @description: IUserService
 * @author: DI CHENG
 * @create: 2018-01-17 10:46
 **/
public interface IUserService {

    User findUserById(Integer id);
}
