package com.zkhr.feignconsumer;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumerApplication {

	@Bean
	Logger.Level feignLoggerLevel() {
		//全局配置日志输出级别
		//1.NONE:不记录任何信息。
		//2.BASIC:仅记录请求方法，URL以及响应状态码和执行时间
		//3.HEADERS：除了记录BASIC级别的信息之外，还会记录请求和响应的头信息
		//4.FULL：记录所有请求与响应的明细，包括头信息，请求体，元数据
		return Logger.Level.FULL;
	}

	public static void main(String[] args) {
		SpringApplication.run(FeignConsumerApplication.class, args);
	}
}
