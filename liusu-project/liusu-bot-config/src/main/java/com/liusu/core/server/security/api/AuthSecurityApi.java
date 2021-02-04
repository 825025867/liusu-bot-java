
 
 /*
 * $Id:$
 * Copyright 2020 hbmisisi.com All rights reserved.
 */
 
package com.liusu.core.server.security.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.liusu.core.server.config.FeignConfig;
import com.liusu.core.server.security.interceptor.RequestHeaderInterceptor;
import com.hbmss.framework.model.ResultDTO;
import com.hbmss.framework.user.UserContext;

/**
 * 
 * @author Leon.Dong
 * @since 2020.10.05
 */
@FeignClient(name="hbmss-cloud-oauth-server", configuration= {FeignConfig.class, RequestHeaderInterceptor.class})
public interface AuthSecurityApi {

  @GetMapping(value = "/oauth/security/usercontext")
  ResultDTO<UserContext> getUserContext();
}

