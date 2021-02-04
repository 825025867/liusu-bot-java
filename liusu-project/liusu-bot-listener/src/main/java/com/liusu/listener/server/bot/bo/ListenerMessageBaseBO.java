package com.liusu.listener.server.bot.bo;

import com.hbmss.framework.model.BaseModel;
import com.liusu.domain.server.constant.MsgTypeEnum;

/**
 * 监听消息BO基类
 * 
 * @author LiuSu
 * @since 2021.01.27
 */
public class ListenerMessageBaseBO extends BaseModel {

  private static final long serialVersionUID = -6108661564678736357L;

  // 发送者ID
  protected Long senderId;

  // 接收者QQ
  protected Long receiveId;

  // 消息内容
  protected String message;

  // 消息类型
  protected MsgTypeEnum messageType;

  @Override
  public String toString() {
    return "MessageEvent [senderId=" + senderId + ", receiveId=" + receiveId + ", message=" + message + ", messageType="
        + messageType + "]";
  }

  public Long getSenderId() {

    return senderId;
  }

  public void setSenderId(Long senderId) {

    this.senderId = senderId;
  }

  public Long getReceiveId() {

    return receiveId;
  }

  public void setReceiveId(Long receiveId) {

    this.receiveId = receiveId;
  }

  public String getMessage() {

    return message;
  }

  public void setMessage(String message) {

    this.message = message;
  }

  public MsgTypeEnum getMessageType() {

    return messageType;
  }

  public void setMessageType(MsgTypeEnum messageType) {

    this.messageType = messageType;
  }

}
