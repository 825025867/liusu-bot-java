
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.send.server.text.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.hbmss.framework.exception.ServiceException;
import com.hbmss.framework.model.ResultDTO;
import com.liusu.domain.server.constant.ErrorMsgEnum;
import com.liusu.domain.server.constant.ListenerBotCfgConstant;
import com.liusu.domain.server.dto.SendTextMsgDTO;
import com.liusu.domain.server.utils.HttpUtils;
import com.liusu.send.server.constant.SendMsgTypeEnum;
import com.liusu.send.server.constant.SendToTypeEnum;
import com.liusu.send.server.utils.SendMsgApiUrlUtils;

import jodd.util.StringUtil;

/**
 * 发送文本消息
 * 
 * @author LiuSu
 * @since 2021.01.28
 */
@Service
public class SendTextMsgService {

  private static final String MSG_TYPE = SendMsgTypeEnum.TEXT_MSG.getCode();

  /**
   * 文本消息Api Url
   * 
   * @return
   * @author LiuSu
   * @since 2021.01.28
   */
  private String getTextMsgUrl() {
    String url = SendMsgApiUrlUtils.textMsgUrl(ListenerBotCfgConstant.LOCATION, ListenerBotCfgConstant.PORT,
        ListenerBotCfgConstant.BOT_QQ, ListenerBotCfgConstant.FUNCNAME_SEND_MSG_V2);
    return url;
  }

  /**
   * 添加atUsers
   * 
   * @param dto
   * @author LiuSu
   * @since 2021.01.28
   */
  private void addAtUsers(SendTextMsgDTO dto) {
    StringBuilder content = new StringBuilder();
    if (dto.getAtUsers().stream().anyMatch(r -> r == 0)) {
      content.append("[ATALL()]");
      List<Long> atUsers = dto.getAtUsers().stream().filter(r -> !r.equals(0L)).collect(Collectors.toList());
      dto.setAtUsers(atUsers);
    }
    content.append("[ATUSER(").append(StringUtil.join(dto.getAtUsers(), ',')).append(")]").append(dto.getContent());
    dto.setContent(content.toString());
  }

  /**
   * 发送群消息
   * 
   * @param dto
   * @return
   * @author LiuSu
   * @since 2021.01.28
   */
  public ResultDTO<String> groupMsg(SendTextMsgDTO dto) {
    if (dto.getToUserUid() == null) {
      throw new ServiceException(ErrorMsgEnum.PARAM_ISNULL_ERROR_MSG.getErrorMsg());
    }

    //是否有At消息
    if (dto.getAtUsers() != null) {
      addAtUsers(dto);
    }
    dto.setSendMsgType(MSG_TYPE);
    dto.setSendToType(SendToTypeEnum.GROUP.getValue());

    String data = new Gson().toJson(dto);
    String url = getTextMsgUrl();
    return ResultDTO.apply(HttpUtils.post(url, data));
  }

  /**
   * 发送好友消息
   * 
   * @param dto
   * @return
   * @author LiuSu
   * @since 2021.01.28
   */
  public ResultDTO<String> friendMsg(SendTextMsgDTO dto) {
    if (dto.getToUserUid() == null) {
      throw new ServiceException(ErrorMsgEnum.PARAM_ISNULL_ERROR_MSG.getErrorMsg());
    }

    dto.setSendMsgType(MSG_TYPE);
    dto.setSendToType(SendToTypeEnum.FRIEND.getValue());

    String data = new Gson().toJson(dto);
    String url = getTextMsgUrl();
    return ResultDTO.apply(HttpUtils.post(url, data));
  }

  /**
   * 发送临时会话(私聊)消息
   * 
   * @param dto
   * @return
   * @author LiuSu
   * @since 2021.01.28
   */
  public ResultDTO<String> tempSessionMsg(SendTextMsgDTO dto) {
    if (dto.getToUserUid() == null || dto.getGroupID() == null) {
      throw new ServiceException(ErrorMsgEnum.PARAM_ISNULL_ERROR_MSG.getErrorMsg());
    }

    dto.setSendMsgType(MSG_TYPE);
    dto.setSendToType(SendToTypeEnum.FRIEND.getValue());

    String data = new Gson().toJson(dto);
    String url = getTextMsgUrl();
    return ResultDTO.apply(HttpUtils.post(url, data));
  }
}
