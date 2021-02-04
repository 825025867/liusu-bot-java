
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.domain.server.dto;

/**
 * 图片消息
 * 
 * @author LiuSu
 * @since 2021.01.28
 */

public class SendPicMsgDTO extends SendMsgDTO {

  private static final long serialVersionUID = -2168406804616635628L;

  /** 图片Url */
  private String PicUrl;

  /**
   * 群消息/好友消息
   * 
   * @param toUserUid 群ID/好友QQ
   * @param Content
   */
  public SendPicMsgDTO(Long toUserUid, String picUrl) {
    super(toUserUid);
    this.PicUrl = picUrl;
  }

  /**
   * 临时会话(私聊)消息
   * 
   * @param toUserUid
   * @param groupID
   * @param content
   */
  public SendPicMsgDTO(Long toUserUid, Long groupID, String picUrl) {
    super(toUserUid, groupID);
    this.PicUrl = picUrl;
  }

  @Override
  public String toString() {
    return "SendTextMsgDTO [PicUrl=" + PicUrl + ", ToUserUid=" + ToUserUid + ", GroupID=" + GroupID + ", SendToType="
        + SendToType + ", SendMsgType=" + SendMsgType + "]";
  }

  public String getPicUrl() {

    return PicUrl;
  }

  public void setPicUrl(String picUrl) {

    PicUrl = picUrl;
  }

}
