
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.pd.server.process.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liusu.pd.server.feign.SendTextMsgApi;

/**
 * 处理消息
 * 
 * @author LiuSu
 * @since 2021.01.26
 */
@Service
public class PdProcessManager {

  @Autowired
  SendTextMsgApi groupMsgApi;

  /**
   * 发送文本消息
   * 
   * @param groupId
   * @param message
   * @return
   * @author LiuSu
   * @since 2021.01.27
   */
  public String textMsg(Long groupId, String message) {
    //    SendTextMsgDTO dto = new SendTextMsgDTO(groupId, message);
    return message;
  }

}
