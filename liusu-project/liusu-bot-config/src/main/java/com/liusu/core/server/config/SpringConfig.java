
/*
* $Id:$
* Copyright 2020 hbmisisi.com All rights reserved.
*/

package com.liusu.core.server.config;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 系统配置类
 * 
 * @author water
 * @since 2020.06.11
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.hbmss.framework", "com.liusu.*.server" })
public class SpringConfig {

  /**
   * setUsePrefix(true) 因为当为false时，realm里的doGetAuthorizationInfo会执行两次
   * setProxyTargetClass(true) 让controller使用cglib代理 用于解决一个奇怪的bug。在引入spring
   * aop的情况下。 在@Controller注解的类的方法中加入@RequiresRole等shiro注解， 会导致该方法无法映射请求，导致返回404。
   * 加入这项配置能解决这个bug
   */
  @Bean
  public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
    DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
    defaultAdvisorAutoProxyCreator.setUsePrefix(true);
    //    defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
    return defaultAdvisorAutoProxyCreator;
  }

  /**
   * Sys log listener sys log listener.
   * 
   * @Bean public SystemLogKafkaListener systemLogKafkaListener() { return new
   *       SystemLogKafkaListener(); }
   */

  /**
   * Sql Log Kafka Listener
   * 
   * @Bean public SqlLogKafkaListener sqlLogKafkaListener() { return new
   *       SqlLogKafkaListener(); }
   */
}
