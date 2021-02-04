
/*
* $Id:$
* Copyright 2020 hbmisisi.com All rights reserved.
*/

package com.liusu.core.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.hbmss.framework.mybatis.cache.redis.RedisTemplateSupport;

/**
 * Redisson Config
 * 
 * @author Leon.Dong
 * @since 2020.09.21
 */
public class RedisConfig {

  @Bean
  public StringRedisSerializer stringRedisSerializer() {
    return new StringRedisSerializer();
  }

  @Bean("redisTemplate")
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory,
      StringRedisSerializer stringRedisSerializer) {
    //    System.out.println("LettuceConnectionFactory factory.getHostName()=" + factory.getClusterConnection().getClass().getCanonicalName());

    RedisTemplate<String, Object> template = new RedisTemplate<>();

    template.setConnectionFactory(factory);
    template.setKeySerializer(stringRedisSerializer);
    template.setHashKeySerializer(stringRedisSerializer);
    return template;
  }
  
  
  @Bean
  RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory) {

      RedisMessageListenerContainer container = new RedisMessageListenerContainer();
      container.setConnectionFactory(connectionFactory);
      return container;
  }
  
  
  @Bean
  public RedisTemplateSupport redisTemplateSupport(RedisTemplate<String, Object> redisTemplate) {
    RedisTemplateSupport redisTemplateSupport = new RedisTemplateSupport();
    redisTemplateSupport.setRedisTemplate(redisTemplate);
    return redisTemplateSupport;
  }

}
