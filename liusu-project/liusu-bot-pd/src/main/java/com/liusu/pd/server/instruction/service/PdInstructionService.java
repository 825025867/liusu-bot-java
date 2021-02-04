
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.pd.server.instruction.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liusu.domain.server.dto.SendPicMsgDTO;
import com.liusu.pd.server.feign.SendPicMsgApi;
import com.liusu.pd.server.feign.SendTextMsgApi;
import com.liusu.pd.server.process.dto.PdProcessGroupDTO;

/**
 * bot指令
 * 
 * @author LiuSu
 * @since 2021.01.28
 */
@Service
public class PdInstructionService {

  @Autowired
  SendTextMsgApi textMsgApi;

  @Autowired
  SendPicMsgApi picMsgApi;

  /**
   * 解析群聊指令
   * 
   * @return
   * @author LiuSu
   * @since 2021.01.28
   */
  public void parseGroupMsg(PdProcessGroupDTO dto) {
    if (dto.getMessage().equals("#菜单")) {
      List<Long> atUsers = new ArrayList<Long>();
      atUsers.add(dto.getSenderId());
      atUsers.add(0L);
      atUsers.add(dto.getSenderId());
      SendPicMsgDTO textMsg = new SendPicMsgDTO(dto.getSenderId(), dto.getGroupID(),
          "http://gchat.qpic.cn/gchatpic_new/825025867/564732654-2534335053-C2C4A89B5CFF5BEE1D5FF38F56CE8F0B/0?vuin=1511587643&term=255&pictype=0");
      //      textMsgApi.groupMsg(textMsg);

      picMsgApi.friendMsg(textMsg);
    }
  }
}
