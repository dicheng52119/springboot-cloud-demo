package com.zkhr.feignconsumer.service;

import com.zkhr.feignconsumer.config.DisableHystrixConfiguration2;
import com.zkhr.feignconsumer.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dicheng on 17-12-21.
 * 1. 使用@FeignClient注解标明需要调用的服务名称
 * 2. 为调用的方法添加访问服务的接口路径
 * 3. fetch内置了断路器，如果不需要，可以全局关闭断路器 feign.hystrix.enabled=false
 * 4. fetch也可以使用configuration属性配置，对指定的客户端的断路器进行关闭
 * 4. fetch实现：在@FeignClient属性fallback配置断路器类
 * 5. fallback配置断路器类需要实现调用断路器的接口,同时使用@Component注解标明这个组件
 * 6. fetch通过配置属性fallbackFactory不仅可以进行断路的回调函数处理，还可以获取断路的原因，可以说是fallback的加强版
 * 7. fallback不能与fallbackFactory同时使用，因为两者都可以自定义回调函数的处理逻辑，放在一块使用会造成冲突
 * 8. fallbackFactory实现步骤：
 *     (1).fallbackFactory属性中指定fallbackFactory回调处理类，此类实现FallbackFactory接口，泛型类型为使用了fallbackFactory属性的接口类型
 *     (2).定义一个新的接口继承使用了fallbackFactory属性的接口
 *     (3).实现fallbackFactory回调处理类中的create方法，return  new 第二步中定义的接口 ，重写接口中的方法作为回调函数处理逻辑
 * 9. @RequestParam @RequestHeader @RequestMapping value值千万不能少，在springmvc中，可以根据参数名来作为默认值，可以缺省
 */
@FeignClient(value = "hello-service", configuration = DisableHystrixConfiguration2.class, /*fallback = HelloServiceFallback.class,*/
fallbackFactory = HelloServiceFallbackFactory.class)
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    //@RequestParam @RequestHeader @RequestMapping value值千万不能少，在springmvc中，可以根据参数名来作为默认值，可以缺省
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);

}
