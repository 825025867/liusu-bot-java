
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.send.server.pic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbmss.framework.model.ResultDTO;
import com.liusu.domain.server.dto.SendPicMsgDTO;
import com.liusu.send.server.pic.service.SendPicMsgService;

/**
 * 发送文本消息
 * 
 * @author LiuSu
 * @since 2021.01.28
 */
@Component
public class SendPicMsgBiz {

  @Autowired
  private SendPicMsgService service;

  /**
   * 发送群消息
   * 
   * @param dto
   * @return
   * @author LiuSu
   * @since 2021.01.28
   */
  public ResultDTO<String> groupMsg(SendPicMsgDTO dto) {
    return service.groupMsg(dto);
  }

  /**
   * 发送好友消息
   * 
   * @param dto
   * @return
   * @author LiuSu
   * @since 2021.01.28
   */
  public ResultDTO<String> friendMsg(SendPicMsgDTO dto) {
    return service.friendMsg(dto);
  }

  /**
   * 临时会话消息
   * 
   * @param dto
   * @return
   * @author LiuSu
   * @since 2021.01.28
   */
  public ResultDTO<String> tempSessionMsg(SendPicMsgDTO dto) {
    return service.tempSessionMsg(dto);
  }
}
