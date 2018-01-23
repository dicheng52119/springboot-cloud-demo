package com.zkhr.elasticjob;

import com.zkhr.elasticjob.configuration.EmbedZookeeperServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @program: springboot-cloud-demo
 * @description: ElasticJobApplication
 * @author: DI CHENG
 * @create: 2018-01-19 11:00
 **/
@SpringBootApplication
public class ElasticJobApplication {

    public static void main(String[] args) {
        EmbedZookeeperServer.start(6181); // 启动内嵌zookeeper
        SpringApplication.run(ElasticJobApplication.class, args);
    }
}
