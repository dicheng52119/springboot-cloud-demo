package com.zkhr.feignconsumer.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by dicheng on 17-12-22.
 * 在HelloService的@FeignCLient注解中，通过configuration参数引入下面的配置
 * 这是其中一种对指定服务开启断路器的方法，另外一种是配置文件中进行指定断路器的全局开启或关闭
 * 默认是返回HystrixFeign.builder(),因为现在调用Feign.builder()，所以禁用了hystrix功能
 */
@Configuration
public class DisableHystrixConfiguration2 {

//    @Bean
//    @Scope("prototype")
//    public Feign.Builder feignBuilder() {
//        return Feign.builder();
//    }
}
