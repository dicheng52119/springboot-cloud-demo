package com.zkhr.ribbonconsumer.service;

import com.zkhr.ribbonconsumer.model.User;

/**
 * @program: springboot-cloud-demo
 * @description: IUserService
 * @author: DI CHENG
 * @create: 2018-01-17 12:03
 **/
public interface IUserService {

    User findUserById(Integer id);

    User findUserById2(Integer id);
}
