package com.zkhr.springboothello.service.impl;

import com.zkhr.springboothello.model.User;
import com.zkhr.springboothello.repository.UserRepository;
import com.zkhr.springboothello.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-cloud-demo
 * @description: UserService
 * @author: DI CHENG
 * @create: 2018-01-17 10:46
 **/
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(Integer id) {
        return userRepository.findUserById(id);
    }
}
