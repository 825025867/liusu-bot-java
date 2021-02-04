
/*
* $Id:$
* Copyright 2020 liusu.com All rights reserved.
*/

package com.liusu.send.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import com.liusu.core.server.config.AsyncConfig;
import com.liusu.core.server.config.FeignConfig;
import com.liusu.core.server.config.RabbitMQConfig;
import com.liusu.core.server.config.RedisConfig;
import com.liusu.core.server.config.SpringConfig;

/**
 * Send 模块 启动类
 * 
 * @author LiuSu
 * @since 2021.01.26
 */
@EnableDiscoveryClient
@SpringBootApplication
@Import({ SpringConfig.class, AsyncConfig.class, FeignConfig.class, RedisConfig.class, RabbitMQConfig.class })
public class SendWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(SendWebApplication.class, args);
  }

  @Component
  class ApplicationRunner implements CommandLineRunner {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(String... args) throws Exception {
      if (logger.isDebugEnabled()) {
        logger.debug("---------LiuSuBot----SendBootWeb Application 启动完成-----------");
      }
    }

  }

}
