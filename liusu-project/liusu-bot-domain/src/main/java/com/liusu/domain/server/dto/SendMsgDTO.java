
package com.liusu.domain.server.dto;

import com.hbmss.framework.model.BaseModel;

/**
 * 发送消息DTO
 * 
 * @author LiuSu
 * @since 2021.01.28
 */
public class SendMsgDTO extends BaseModel {

  private static final long serialVersionUID = -8119813090526559246L;

  /** 好友QQ/群ID/私聊对象QQ */
  protected Long ToUserUid;

  /** 临时会话(私聊)时的群ID */
  protected Long GroupID;

  /** 发送对象类型(1 为好友消息 2 发送群消息 3 发送私聊消息) */
  protected Short SendToType;

  /** 消息类型 */
  protected String SendMsgType;

  /**
   * 群消息和好友消息构造方法
   * 
   * @param ToUserUid
   */
  public SendMsgDTO(Long ToUserUid) {
    super();
    this.ToUserUid = ToUserUid;
  }

  /**
   * 临时会话(私聊)消息构造方法
   * 
   * @param toUserUid
   * @param groupID
   */
  public SendMsgDTO(Long toUserUid, Long groupID) {
    super();
    ToUserUid = toUserUid;
    GroupID = groupID;
  }

  @Override
  public String toString() {
    return "SendMsgDTO [ToUserUid=" + ToUserUid + ", GroupID=" + GroupID + ", SendToType=" + SendToType
        + ", SendMsgType=" + SendMsgType + "]";
  }

  public Long getGroupID() {

    return GroupID;
  }

  public void setGroupID(Long groupID) {

    GroupID = groupID;
  }

  public Long getToUserUid() {

    return ToUserUid;
  }

  public void setToUserUid(Long ToUserUid) {

    this.ToUserUid = ToUserUid;
  }

  public Short getSendToType() {

    return SendToType;
  }

  public void setSendToType(Short SendToType) {

    this.SendToType = SendToType;
  }

  public String getSendMsgType() {

    return SendMsgType;
  }

  public void setSendMsgType(String SendMsgType) {

    this.SendMsgType = SendMsgType;
  }

}
