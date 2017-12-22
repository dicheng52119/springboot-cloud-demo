package com.zkhr.feignconsumer.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by dicheng on 17-12-22.
 * 在HelloService的@FeignCLient注解中，通过configuration参数引入下面的配置
 * 这是其中一种对指定服务开启断路器的方法，另外一种是配置文件中进行指定
 */
@Configuration
public class DisableHystrixConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
