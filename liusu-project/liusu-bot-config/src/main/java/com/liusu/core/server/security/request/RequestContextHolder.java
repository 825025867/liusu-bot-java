/*
 * Copyright 2020 gracesleon.com All rights reserved.
 */
package com.liusu.core.server.security.request;

import org.springframework.core.NamedInheritableThreadLocal;
import org.springframework.core.NamedThreadLocal;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.lang.Nullable;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * ReactiveRequestContextHolder
 *
 * @author Hejue
 */
public abstract class RequestContextHolder {

  private static final ThreadLocal<NativeWebRequest> requestHolder =
      new NamedThreadLocal<>("Request attributes");

  private static final ThreadLocal<NativeWebRequest> inheritableRequestHolder =
      new NamedInheritableThreadLocal<>("Request context");

  /**
   * Reset the RequestAttributes for the current thread.
   */
  public static void resetRequest() {
    requestHolder.remove();
    inheritableRequestHolder.remove();
  }

  /**
   * Bind the given RequestAttributes to the current thread,
   * <i>not</i> exposing it as inheritable for child threads.
   *
   * @param request the RequestAttributes to expose
   * @see #setRequest(ServerHttpRequest, boolean)
   */
  public static void setRequest(@Nullable NativeWebRequest request) {
    setRequest(request, false);
  }

  /**
   * Bind the given RequestAttributes to the current thread.
   *
   * @param request the RequestAttributes to expose, or {@code null} to reset the thread-bound
   * context
   * @param inheritable whether to expose the RequestAttributes as inheritable for child threads
   * (using an {@link InheritableThreadLocal})
   */
  public static void setRequest(@Nullable NativeWebRequest request, boolean inheritable) {
    if (request == null) {
      resetRequest();
    } else {
      if (inheritable) {
        inheritableRequestHolder.set(request);
        requestHolder.remove();
      } else {
        requestHolder.set(request);
        inheritableRequestHolder.remove();
      }
    }
  }

  /**
   * Return the RequestAttributes currently bound to the thread.
   *
   * @return the RequestAttributes currently bound to the thread, or {@code null} if none bound
   */
  @Nullable
  public static NativeWebRequest getRequest() {
    NativeWebRequest attributes = requestHolder.get();
    if (attributes == null) {
      attributes = inheritableRequestHolder.get();
    }
    return attributes;
  }
}
