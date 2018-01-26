package com.zkhr.streamrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StreamRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamRabbitmqApplication.class, args);
	}
}
