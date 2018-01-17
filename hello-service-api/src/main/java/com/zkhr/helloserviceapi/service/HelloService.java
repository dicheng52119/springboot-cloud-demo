package com.zkhr.helloserviceapi.service;

import com.zkhr.helloserviceapi.dto.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dicheng on 17-12-22.
 * 通过继承的方式完成fetch服务端和消费端代码的抽取
 * 1. 定义通用接口，封装所有接口方法和访问路径
 * 2. fetch服务提供方controller需要实现这个通用接口，controller只需要使用@RestController注解表明这是一个web服务即可，方法路径映射不用，只需实现接口方法即可
 * 3. fetch服务消费方需要定义一个接口，继承第一步中定义的通用接口，使用@FeignClient注解标明调用服务的名称
 * 4. fetch注入第三步中定义的接口，调用接口方法
 */
@RequestMapping("/refactor")
public interface HelloService {

    //@RequestParam @RequestHeader @RequestMapping value值千万不能少，在springmvc中，可以根据参数名来作为默认值，可以缺省
    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello5", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello6", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
