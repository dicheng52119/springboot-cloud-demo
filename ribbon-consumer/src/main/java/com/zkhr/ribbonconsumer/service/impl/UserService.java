package com.zkhr.ribbonconsumer.service.impl;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zkhr.ribbonconsumer.model.User;
import com.zkhr.ribbonconsumer.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springboot-cloud-demo
 * @description: UserService
 * @author: DI CHENG
 * @create: 2018-01-17 12:03
 **/
@Service
public class UserService implements IUserService {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    /**
     * hystrix状态有三种：1.开启 2.关闭 3.半开
     * 当失败的次数达到一定的阈值后，断路器处于开启，否则处于关闭
     * 如果未达到断路器的连接超时，断路器处于半开状态，即一部分请求还是可以发送的，达到超时时间，断路器打开，请求不进行发送
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "findUserByIdFallback")
    public User findUserById(Integer id) {

        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/user/findUserById?id={1}", User.class, "1");
        User user = responseEntity.getBody();
        logger.info("==根据id消费user对象=="+ JSON.toJSONString(user));
        return user;
    }

    /**
     * hystrix 回调函数
     * 注意：1. 参数与原函数一致
     *      2. 返回值与原函数一致
     *      3. 方法名自定义
     * @param id
     * @return
     */
    public User findUserByIdFallback(Integer id) {
        User user = new User();
        user.setId(0);
        user.setName("hystrix 触发回调函数");
        return user;
    }

    /**
     * HystrixProperty设置一些hystrix的属性
     * execution.isolation.strategy为隔离策略，有两种方式，一种是semaphore，一种是thread，默认和建议的是thread
     * 隔离策略的作用：原函数和@HystrixCommand执行是通过两个线程进行执行的，通过隔离策略绑定在一个线程进行运行
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "findUserByIdFallback2",commandProperties = @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"))
    public User findUserById2(Integer id) {

        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/user/findUserById?id={1}", User.class, "1");
        User user = responseEntity.getBody();
        logger.info("==根据id消费user对象=="+ JSON.toJSONString(user));
        return user;
    }

    /**
     * hystrix 回调函数
     * 注意：1. 参数与原函数一致
     *      2. 返回值与原函数一致
     *      3. 方法名自定义
     * @param id
     * @return
     */
    public User findUserByIdFallback2(Integer id) {
        User user = new User();
        user.setId(0);
        user.setName("hystrix 触发回调函数");
        return user;
    }
}
