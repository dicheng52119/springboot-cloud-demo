package com.zkhr.elasticjob.job.simple;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.zkhr.elasticjob.domain.Foo;
import com.zkhr.elasticjob.repository.FooRepository;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: springboot-cloud-demo
 * @description: SpringSimpleJob 作业业务处理类
 * @author: DI CHENG
 * @create: 2018-01-19 10:42
 **/
public class SpringSimpleJob implements SimpleJob {

    @Resource
    private FooRepository fooRepository;

    //根据分片参数(即键对应的值)匹配到对应的执行逻辑
//    @Override
//    public void execute(ShardingContext shardingContext) {
//        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
//                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread.currentThread().getId(), "SIMPLE"));
//        //根据分片参数(即键对应的值)匹配到对应的执行逻辑
//        List<Foo> data = fooRepository.findTodoData(shardingContext.getShardingParameter(), 10);
//        for (Foo each : data) {
//            fooRepository.setCompleted(each.getId());
//        }
//    }

    //根据分片键匹配到对应的执行逻辑
    @Override
    public void execute(ShardingContext context) {
        switch (context.getShardingItem()) {
            case 0:
                // do something by sharding item 0
                System.out.println("==属于beijing作业分片的业务逻辑==");
                break;
            case 1:
                // do something by sharding item 1
                System.out.println("==属于shanghai作业分片的业务逻辑==");
                break;
            case 2:
                // do something by sharding item 2
                System.out.println("==属于guangzhou作业分片的业务逻辑==");
                break;
            // case n: ...
        }
    }
}
