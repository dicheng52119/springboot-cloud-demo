package com.zkhr.cloudtask.runner;

import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;

/**
 * @program: springboot-cloud-demo
 * @description: TestCommandLineRunner
 * @author: DI CHENG
 * @create: 2018-01-18 10:04
 **/
public class TestCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("this is a Test about spring cloud task.");

        try {
            ArrayList<String> list = new ArrayList<>();
            list.get(1);
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
