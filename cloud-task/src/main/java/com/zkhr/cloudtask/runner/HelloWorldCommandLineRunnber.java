package com.zkhr.cloudtask.runner;

import org.springframework.boot.CommandLineRunner;

/**
 * @program: springboot-cloud-demo
 * @description: HelloWorldCommandLineRunnber
 * @author: DI CHENG
 * @create: 2018-01-18 10:15
 **/
public class HelloWorldCommandLineRunnber implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("hello world !");
    }
}
