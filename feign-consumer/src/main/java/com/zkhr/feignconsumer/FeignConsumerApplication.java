package com.zkhr.feignconsumer;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * 其实feign中自带了hystrix,如果单纯的使用hystrix功能，可以不加@EnableCircuitBreaker注解
 * 使用@EnableCircuitBreaker注解可以使用其中的hystrix-metrics-event-stream，用于dashboard
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
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
