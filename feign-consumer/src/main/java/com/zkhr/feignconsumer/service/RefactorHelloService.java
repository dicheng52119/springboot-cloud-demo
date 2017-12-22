package com.zkhr.feignconsumer.service;

import com.zkhr.helloserviceapi.service.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by dicheng on 17-12-22.
 */
@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends HelloService {


}
