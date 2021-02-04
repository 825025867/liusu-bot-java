
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.send.server.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

/**
 * 发送Http请求
 * 
 * @author LiuSu
 * @since 2021.01.26
 */

@Component
public class SendRequestManager {

  public final Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * 发送消息
   * 
   * @author LiuSu
   * @since 2021.01.26
   */
  public String sendMsg(String strUrl, JSONObject data) {
    return null;
  }
}
