
/*
* $Id:$
* Copyright 2020 hbmisisi.com All rights reserved.
*/

package com.liusu.core.server.web.method.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.liusu.core.server.security.api.AuthSecurityApi;
import com.liusu.core.server.security.request.RequestContextHolder;
import com.hbmss.framework.model.ResultDTO;
import com.hbmss.framework.user.UserContext;

/**
 * @author Leon.Dong
 * @since 2020.09.28
 */

public class AuthUserContextArgumentResolver implements HandlerMethodArgumentResolver {

  public final Logger logger = LoggerFactory.getLogger(getClass());

  Object UNRESOLVED = new Object();

  @Autowired
  private AuthSecurityApi authSecurityApi;

  /**
   * (non-Javadoc)
   * 
   * @see org.springframework.web.bind.support.WebArgumentResolver#resolveArgument(org.springframework.core.MethodParameter,
   *      org.springframework.web.context.request.NativeWebRequest)
   */

  @Override
  public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mavContainer,
      NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    if (logger.isDebugEnabled()) {
      logger.debug(" --- AuthUserContextArgumentResolver resolveArgument ---- ");
    }
    RequestContextHolder.setRequest(webRequest);
    if (methodParameter != null && methodParameter.getParameterType() != null) {
      if (supportsParameter(methodParameter)) {
        ResultDTO<UserContext> dto = authSecurityApi.getUserContext();
        if (dto.isSuccess()) {
          if (logger.isDebugEnabled()) {
            logger.debug("The current user is {}", dto.getData());
          }
          return dto.getData();
        }
      }
    }

    return UNRESOLVED;
  }

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return UserContext.class.equals(parameter.getParameterType());
  }

}
