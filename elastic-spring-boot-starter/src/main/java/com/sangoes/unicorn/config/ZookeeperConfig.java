package com.sangoes.unicorn.config;


import com.dangdang.ddframe.job.api.ElasticJob;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.sangoes.unicorn.annotation.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (c) sangoes 2018
 * https://github.com/sangoes
 * zookeeper 配置
 *
 * @author jerrychir
 * @date 2019 2019/2/22 11:24 AM
 */
@Configuration
@ConditionalOnClass(ElasticJob.class)
@ConditionalOnBean(annotation = Schedule.class)
@EnableConfigurationProperties(ZookeeperProperties.class)
public class ZookeeperConfig {


    private final ZookeeperProperties zookeeperProperties;

    @Autowired
    public ZookeeperConfig(ZookeeperProperties zookeeperProperties) {
        this.zookeeperProperties = zookeeperProperties;
    }

    /**
     * 注入registryCenter
     *
     * @return registryCenter
     */
    @ConditionalOnMissingBean
    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter registryCenter() {
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(zookeeperProperties.getServerLists(), zookeeperProperties.getNamespace());
        zookeeperConfiguration.setBaseSleepTimeMilliseconds(zookeeperProperties.getBaseSleepTimeMilliseconds());
        zookeeperConfiguration.setConnectionTimeoutMilliseconds(zookeeperProperties.getConnectionTimeoutMilliseconds());
        zookeeperConfiguration.setMaxSleepTimeMilliseconds(zookeeperProperties.getMaxSleepTimeMilliseconds());
        zookeeperConfiguration.setSessionTimeoutMilliseconds(zookeeperProperties.getSessionTimeoutMilliseconds());
        zookeeperConfiguration.setMaxRetries(zookeeperProperties.getMaxRetries());
        zookeeperConfiguration.setDigest(zookeeperProperties.getDigest());
        return new ZookeeperRegistryCenter(zookeeperConfiguration);
    }
}
