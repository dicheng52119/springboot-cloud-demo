package com.zkhr.cloudtask.listener;

import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-cloud-demo
 * @description: MyBean 任务执行监听器配置
 * 1. @BeforeTask 任务开始执行之前监听器
 * 2. @AfterTask 任务执行之后，结束之前监听器
 * 3. @FailedTask 任务执行异常，结束之前监听器
 * @author: DI CHENG
 * @create: 2018-01-18 10:48
 **/
@Component
public class TaskListener {

    @BeforeTask
    public void methodA(TaskExecution taskExecution) {
        System.out.println("==任务执行之前==");
    }

    @AfterTask
    public void methodB(TaskExecution taskExecution) {
        System.out.println("==任务执行中==");
    }

    @FailedTask
    public void methodC(TaskExecution taskExecution, Throwable throwable) {
        System.out.println("==任务执行发生错误==");
    }

}
