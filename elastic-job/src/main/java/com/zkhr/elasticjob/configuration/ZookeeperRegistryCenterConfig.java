package com.zkhr.elasticjob.configuration;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springboot-cloud-demo
 * @description: ZookeeperRegistryCenterConfig 注册中心配置 用于注册和协调作业分布式行为的组件，目前仅支持Zookeeper。
 * @author: DI CHENG
 * @create: 2018-01-18 20:56
 **/
@Configuration
@ConditionalOnExpression("'${regCenter.serverList}'.length()>0")
public class ZookeeperRegistryCenterConfig {
    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(@Value("${regCenter.serverList}") final String serverList,
                                             @Value("${regCenter.namespace}") final String namespace){
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList,namespace));
    }
}