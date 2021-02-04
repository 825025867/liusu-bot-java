
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.domain.server.dto;

import java.util.List;

/**
 * 文本类消息
 * 
 * @author LiuSu
 * @since 2021.01.28
 */

public class SendTextMsgDTO extends SendMsgDTO {

  private static final long serialVersionUID = -2168406804616635628L;

  /** 消息内容 */
  private String Content;

  /** AT user */
  private List<Long> atUsers;

  /**
   * atUser群消息
   * 
   * @param toUserUid
   * @param Content
   * @param atUsers
   */

  public SendTextMsgDTO(Long ToUserUid, String content, List<Long> atUsers) {
    super(ToUserUid);
    Content = content;
    this.atUsers = atUsers;
  }

  /**
   * 普通群消息/好友消息
   * 
   * @param toUserUid 群ID/好友QQ
   * @param Content
   */
  public SendTextMsgDTO(Long toUserUid, String Content) {
    super(toUserUid);
    this.Content = Content;
  }

  /**
   * 临时会话(私聊)消息
   * 
   * @param toUserUid
   * @param groupID
   * @param content
   */
  public SendTextMsgDTO(Long toUserUid, Long groupID, String content) {
    super(toUserUid, groupID);
    Content = content;
  }

  @Override
  public String toString() {
    return "SendTextMsgDTO [Content=" + Content + ", atUsers=" + atUsers + ", ToUserUid=" + ToUserUid + ", GroupID="
        + GroupID + ", SendToType=" + SendToType + ", SendMsgType=" + SendMsgType + "]";
  }

  public String getContent() {

    return Content;
  }

  public void setContent(String Content) {

    this.Content = Content;
  }

  public List<Long> getAtUsers() {

    return atUsers;
  }

  public void setAtUsers(List<Long> atUsers) {

    this.atUsers = atUsers;
  }

}
