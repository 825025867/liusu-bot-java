package com.liusu.pd.server.process.dto;

import com.hbmss.framework.model.BaseModel;
import com.liusu.domain.server.constant.MsgTypeEnum;

/**
 * 监听消息DTO基类
 * 
 * @author LiuSu
 * @since 2021.01.27
 */
public class PdProcessBaseDTO extends BaseModel {

  private static final long serialVersionUID = 8552523856831933220L;

  // 发送者ID
  protected long senderId;

  // 接收者QQ
  protected long receiveId;

  // 消息内容
  protected String message;

  // 消息类型
  protected MsgTypeEnum messageType;

  @Override
  public String toString() {
    return "ListenerMessageBaseDTO [senderId=" + senderId + ", receiveId=" + receiveId + ", message=" + message
        + ", messageType=" + messageType + "]";
  }

  public long getSenderId() {

    return senderId;
  }

  public void setSenderId(long senderId) {

    this.senderId = senderId;
  }

  public long getReceiveId() {

    return receiveId;
  }

  public void setReceiveId(long receiveId) {

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
