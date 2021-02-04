
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.pd.server.process.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbmss.framework.model.ResultDTO;
import com.liusu.pd.server.process.dto.PdProcessFriendDTO;
import com.liusu.pd.server.process.dto.PdProcessGroupDTO;
import com.liusu.pd.server.process.service.PdProcessService;

/**
 * 处理监听消息
 * 
 * @author LiuSu
 * @since 2021.01.28
 */
@Component
public class PdProcessBiz {

  @Autowired
  PdProcessService service;

  /**
   * 处理群聊消息
   * 
   * @param dto
   * @return
   * @author LiuSu
   * @since 2021.01.27
   */
  public ResultDTO<Boolean> groupMsg(PdProcessGroupDTO dto) {
    return service.groupMsg(dto);
  }

  /**
   * 处理私聊消息
   * 
   * @param dto
   * @return
   * @author LiuSu
   * @since 2021.01.28
   */
  public ResultDTO<Boolean> friendMsg(PdProcessFriendDTO dto) {
    return service.friendMsg(dto);
  }
}
