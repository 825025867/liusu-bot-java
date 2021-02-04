/*
 * $Id:$
 * Copyright 2019 gracesleon.com All rights reserved.
 */
package com.liusu.core.server.security.interceptor;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.NativeWebRequest;

import com.liusu.core.server.security.request.RequestContextHolder;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Copy request headers to feign request.
 *
 * @author Hejue
 * @since 2020.07.24
 */
public class RequestHeaderInterceptor implements RequestInterceptor {

  private static final Logger log = LoggerFactory.getLogger(RequestHeaderInterceptor.class);
  
  @Override
  public void apply(RequestTemplate template) {
    NativeWebRequest request = RequestContextHolder.getRequest();
    log.debug(" --- Thread.currentThread().getName() ={} ---- ", Thread.currentThread().getName());
    log.debug(" --- RequestHeaderInterceptor apply -request != null is {}--- ",request == null);
    if (request != null) {
      if (log.isDebugEnabled()) {
        log.debug(request.getHeaderNames().toString());
      }
      Iterator<String> e = request.getHeaderNames();
      while (e.hasNext()) {
        String key = e.next();
        String[] value = request.getHeaderValues(key);
        template.header(key, value);
        log.debug(" --- request.getHeaders() is {}={}--- ",key, value);
      }
    }
  }
}
