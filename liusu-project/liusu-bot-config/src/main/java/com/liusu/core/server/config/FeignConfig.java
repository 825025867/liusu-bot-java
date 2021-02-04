/*
 * Copyright 2020 gracesleon.com All rights reserved.
 */
package com.liusu.core.server.config;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import feign.Feign;
import feign.Logger;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import feign.querymap.BeanQueryMapEncoder;

/**
 * Feign configuration.
 *
 * @author Hejue
 * @since 2020.07.22
 */
@EnableFeignClients("com.liusu.*.server")
public class FeignConfig {

  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }

  @Autowired
  private ObjectFactory<HttpMessageConverters> messageConverters;

  @Bean
  public Encoder feignFormEncoder() {
    return new SpringFormEncoder(new SpringEncoder(messageConverters));
  }

  @Bean
  public Decoder feignDecoder() {
    return new ResponseEntityDecoder(new SpringDecoder(feignHttpMessageConverter()));
  }

  private ObjectFactory<HttpMessageConverters> feignHttpMessageConverter() {
    var mediaTypes = new ArrayList<MediaType>();
    mediaTypes.add(MediaType.TEXT_HTML);
    mediaTypes.add(MediaType.TEXT_PLAIN);

    var msgConverter = new MappingJackson2HttpMessageConverter();
    msgConverter.setSupportedMediaTypes(mediaTypes);
    return () -> new HttpMessageConverters(msgConverter);
  }

  @Bean
  @ConditionalOnMissingBean
  public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
    return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
  }

  /**
   * @Description 替换解析queryMap的类，实现父类中变量的映射
   * @date 2019/5/21 16:59
   * @version V1.0.0
   */
  @Bean
  public Feign.Builder feignBuilder() {
    return Feign.builder().queryMapEncoder(new BeanQueryMapEncoder()).retryer(Retryer.NEVER_RETRY);
  }
}
