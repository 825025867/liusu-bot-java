
/*
* $Id:$
* Copyright 2020 hbmisisi.com All rights reserved.
*/

package com.liusu.core.server.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.fastjson.util.IOUtils;
import com.liusu.core.server.web.method.support.AuthUserContextArgumentResolver;
import com.hbmss.framework.data.web.method.support.PageQOHandlerMethodArgumentResolver;
import com.hbmss.framework.mvc.converter.json.serializer.LongValueFilter;
import com.hbmss.framework.mvc.interceptor.HandleTimeInterceptor;

/**
 * @author Leon.Dong
 * @since 2020.09.21
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

  /**
   * 添加自定义解析器
   */
  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    /* 
     * 采用注解方式配置MVC，支持分页和排序。
     * 参考：http://docs.spring.io/spring-data/data-commons/docs/1.13.1.RELEASE/reference/html
     */
    PageQOHandlerMethodArgumentResolver pageResolver = new PageQOHandlerMethodArgumentResolver(
        new SortHandlerMethodArgumentResolver());
    argumentResolvers.add(pageResolver);
    argumentResolvers.add(new SortHandlerMethodArgumentResolver());

    // 用户信息自动注入
    argumentResolvers.add(authUserContextArgumentResolver());

  }

  /**
   * 添加FastJson Converter
   */
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(0, fastJsonHttpMessageConverter());
  }

  /**
   * 添加自定义拦截器
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new HandleTimeInterceptor()).addPathPatterns("/**");
  }

  /**
   * 添加静态资源映射
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
  }

  /**
   * 添加跨域设置
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**") //配置允许跨域的路径
        .allowedOrigins("*") //配置允许访问的跨域资源的请求域名
        .allowedMethods("*")
        //配置允许访问该跨域资源服务器的请求方法，如：POST、GET、PUT、DELETE等
        .allowedHeaders("*").allowCredentials(true).maxAge(3600);; //配置允许请求header的访问，如 ：X-TOKEN
  }

  @Bean
  public AuthUserContextArgumentResolver authUserContextArgumentResolver() {
    return new AuthUserContextArgumentResolver();
  }

  /**
   * 配置Fastjson支持
   * 
   * @return
   * @author leon
   * @since 2019.01.17
   */
  private FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
    List<MediaType> fastMediaTypes = new ArrayList<>();
    fastMediaTypes.add(MediaType.APPLICATION_JSON);
    fastMediaTypes.add(MediaType.TEXT_PLAIN);
    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
    converter.setSupportedMediaTypes(fastMediaTypes);
    converter.setDefaultCharset(IOUtils.UTF8);
    converter.setFastJsonConfig(fastJsonConfig());

    return converter;
  }

  /**
   * alibaba fastJsonConfig
   * 
   * @return FastJsonConfig
   * @author leon
   * @since 2019.01.17
   */
  private FastJsonConfig fastJsonConfig() {
    FastJsonConfig config = new FastJsonConfig();
    config.setSerializeFilters(new LongValueFilter());
    config.setSerializerFeatures(SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNonStringKeyAsString,
        SerializerFeature.DisableCircularReferenceDetect);

    return config;
  }

}
