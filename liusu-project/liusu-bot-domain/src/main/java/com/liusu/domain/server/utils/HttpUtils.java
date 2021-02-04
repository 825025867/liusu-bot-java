
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.domain.server.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.hbmss.framework.exception.ServiceException;
import com.liusu.domain.server.constant.SendHttpErrorMsgEnum;

/**
 * HttpUtils
 * 
 * @author LiuSu
 * @since 2021.01.28
 */

public class HttpUtils {

  public static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

  /**
   * POST
   * 
   * @param strUrl
   * @param data
   * @return
   * @author LiuSu
   * @since 2021.01.28
   * @description application/json
   */
  public static String post(String strUrl, String data) {
    if (logger.isDebugEnabled()) {
//      logger.debug("请求数据:URL-->{}   data-->{}", strUrl, data);
    }
    HttpURLConnection connection = null;
    String rt = null;

    try {
      connection = (HttpURLConnection) new URL(strUrl).openConnection();
    } catch (IOException e) {
      throw new ServiceException(SendHttpErrorMsgEnum.URL_ERROR_MSG.getErrorMsg(), e);
    }

    connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    connection.setRequestProperty("Charset", "UTF-8");
    connection.setRequestProperty("Connection", "Keep-Alive");
    connection.setUseCaches(false);
    connection.setDoOutput(true);

    try {
      connection.setRequestMethod("POST");
      connection.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      throw new ServiceException(SendHttpErrorMsgEnum.REQUEST_ERROR_MSG.getErrorMsg(), e);
    }

    try {
      rt = JSON.parseObject(connection.getInputStream(), JSON.class).toString();
    } catch (IOException e) {
      throw new ServiceException(SendHttpErrorMsgEnum.RESPONSE_RESOLVE_ERROR_MSG.getErrorMsg(), e);
    }
    if (logger.isDebugEnabled()) {
      logger.debug("响应结果:{}", rt);
    }
    return rt;
  }
}
