
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.pd.server.process.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbmss.framework.model.ResultDTO;
import com.liusu.domain.server.constant.ListenerBotCfgConstant;
import com.liusu.pd.server.instruction.service.PdInstructionService;
import com.liusu.pd.server.process.dto.PdProcessFriendDTO;
import com.liusu.pd.server.process.dto.PdProcessGroupDTO;

/**
 * 处理监听消息
 * 
 * @author LiuSu
 * @since 2021.01.26
 */
@Service
public class PdProcessService {

  @Autowired
  private PdInstructionService instructionService;

  /**
   * 处理群聊消息
   * 
   * @param dto
   * @return
   * @throws Exception
   * @author LiuSu
   * @since 2021.01.27
   */
  public ResultDTO<Boolean> groupMsg(PdProcessGroupDTO dto) {
    boolean instructionPrefixBls = StringUtils.isNotEmpty(dto.getMessage())
        && dto.getMessage().substring(0, 1).equals(ListenerBotCfgConstant.INSTRUCTION_PREFIX);

    //是否为指令前缀
    if (instructionPrefixBls) {
      instructionService.parseGroupMsg(dto);
    }
    return ResultDTO.apply(true);
  }

  /**
   * 处理私聊消息
   * 
   * @param dto
   * @return
   * @throws Exception
   * @author LiuSu
   * @since 2021.01.28
   */
  public ResultDTO<Boolean> friendMsg(PdProcessFriendDTO dto) {
//    System.out.println("请求成功" + dto.toString());
    return ResultDTO.apply(true);
  }
}
