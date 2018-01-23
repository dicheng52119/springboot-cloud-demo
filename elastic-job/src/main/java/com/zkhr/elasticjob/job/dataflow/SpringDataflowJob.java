package com.zkhr.elasticjob.job.dataflow;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.zkhr.elasticjob.domain.Foo;
import com.zkhr.elasticjob.repository.FooRepository;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: springboot-cloud-demo
 * @description: SpringDataFlowJob 作业业务处理类
 * @author: DI CHENG
 * @create: 2018-01-19 14:34
 **/
public class SpringDataflowJob implements DataflowJob<Foo>{

    @Resource
    private FooRepository fooRepository;


    //根据分片参数(即键对应的值)匹配到对应的执行逻辑
    @Override
    public List<Foo> fetchData(ShardingContext shardingContext) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread.currentThread().getId(), "DATAFLOW FETCH"));
        return fooRepository.findTodoData(shardingContext.getShardingParameter(), 10);
    }

    //根据分片键匹配到对应的执行逻辑
//    @Override
//    public List<Foo> fetchData(ShardingContext context) {
//        switch (context.getShardingItem()) {
//            case 0:
////                List<Foo> data = // get data from database by sharding item 0
////                return data;
//            case 1:
////                List<Foo> data = // get data from database by sharding item 1
////                return data;
//            case 2:
////                List<Foo> data = // get data from database by sharding item 2
////                return data;
//            // case n: ...
//        }
//        return null;
//    }

    @Override
    public void processData(ShardingContext shardingContext, List<Foo> data) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread.currentThread().getId(), "DATAFLOW PROCESS"));
        for (Foo each : data) {
            fooRepository.setCompleted(each.getId());
        }
    }
}
