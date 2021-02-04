package com.liusu.pd.server.process.dto;

import java.util.Arrays;

import com.liusu.domain.server.bo.ListenerPictureBO;

/**
 * 监听私聊消息DTO
 * 
 * @author LiuSu
 * @since 2021.01.28
 */
public class PdProcessFriendDTO extends PdProcessBaseDTO {

  private static final long serialVersionUID = 7465164752972213210L;

  // 接受者的QQ(所有消息类型均有)
  private long toUser;

  // 消息顺序号(所有消息类型均有)
  private long messageSequence;

  //消息中的图片或大表情(PicMsg,BigFaceMsg)
  private ListenerPictureBO[] pictures;

  //消息中的图片或大表情(PicMsg,BigFaceMsg)
  private ListenerPictureBO picture;

  //非文本消息的表示形式(PicMsg,BigFaceMsg)
  private String tips;

  @Override
  public String toString() {
    return "ListenerFriendMessageDTO [toUser=" + toUser + ", messageSequence=" + messageSequence + ", pictures="
        + Arrays.toString(pictures) + ", picture=" + picture + ", tips=" + tips + ", senderId=" + senderId
        + ", receiveId=" + receiveId + ", message=" + message + ", messageType=" + messageType + "]";
  }

  public long getToUser() {

    return toUser;
  }

  public void setToUser(long toUser) {

    this.toUser = toUser;
  }

  public long getMessageSequence() {

    return messageSequence;
  }

  public void setMessageSequence(long messageSequence) {

    this.messageSequence = messageSequence;
  }

  public ListenerPictureBO[] getPictures() {

    return pictures;
  }

  public void setPictures(ListenerPictureBO[] pictures) {

    this.pictures = pictures;
  }

  public ListenerPictureBO getPicture() {

    return picture;
  }

  public void setPicture(ListenerPictureBO picture) {

    this.picture = picture;
  }

  public String getTips() {

    return tips;
  }

  public void setTips(String tips) {

    this.tips = tips;
  }

}
