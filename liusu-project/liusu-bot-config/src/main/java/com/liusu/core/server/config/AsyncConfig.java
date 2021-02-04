
 
 /*
 * $Id:$
 * Copyright 2020 hbmisisi.com All rights reserved.
 */
 
package com.liusu.core.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 线程池的配置
 * @author Ice.Wang
 * @since 2020.10.20
 */
@EnableAsync
public class AsyncConfig {


  private static final int MAX_POOL_SIZE = 50;

  private static final int CORE_POOL_SIZE = 20;

  @Bean("asyncTaskExecutor")
  public AsyncTaskExecutor asyncTaskExecutor() {
      ThreadPoolTaskExecutor asyncTaskExecutor = new ThreadPoolTaskExecutor();
      asyncTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
      asyncTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);
      asyncTaskExecutor.setThreadNamePrefix("async-task-thread-pool-");
      asyncTaskExecutor.initialize();
      return asyncTaskExecutor;
  }
}

