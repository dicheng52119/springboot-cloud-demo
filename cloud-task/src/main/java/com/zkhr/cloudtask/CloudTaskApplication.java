package com.zkhr.cloudtask;

import com.zkhr.cloudtask.runner.HelloWorldCommandLineRunnber;
import com.zkhr.cloudtask.runner.TestCommandLineRunner;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

/**
 * @program: springboot-cloud-demo
 * @description: CloudTaskApplication
 * 1. Spring Batch Job Task: This is a Spring Cloud Task application that executes two simple Spring Batch Jobs.
 * @author: DI CHENG
 * @create: 2018-01-18 09:51
 **/
@SpringBootApplication
@EnableTask
@EnableBatchProcessing
public class CloudTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudTaskApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner() {
//        return new TestCommandLineRunner();
//    }

    @Bean
    public CommandLineRunner helloworldCommandLineRunner() {
        return new HelloWorldCommandLineRunnber();
    }
}
