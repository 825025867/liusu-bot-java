package com.liusu.listener.server.bot.bo;

import java.util.Arrays;

import com.liusu.domain.server.bo.ListenerPictureBO;
import com.liusu.domain.server.bo.ListenerVideoBO;

/**
 * 监听私聊消息BO
 * 
 * @author LiuSu
 * @since 2021.01.28
 */
public class ListenerFriendMessageBO extends ListenerMessageBaseBO {

  private static final long serialVersionUID = 7368731442210647959L;

  // 接受者的QQ(所有消息类型均有)
  private Long toUser;

  // 消息顺序号(所有消息类型均有)
  private Long messageSequence;

  //消息中的图片或大表情(PicMsg,BigFaceMsg)
  private ListenerPictureBO[] pictures;

  //消息中的图片或大表情(PicMsg,BigFaceMsg)
  private ListenerPictureBO picture;

  //非文本消息的表示形式(PicMsg,BigFaceMsg)
  private String tips;

  //临时会话消息(TempSessionMsg-临时会话消息)
  private Long tempUin;

  //群ID(TempSessionMsg-临时会话消息)
  private Long groupID;

  //视频消息
  private ListenerVideoBO video;

  //语音消息的url(VoiceMsg)
  private String voiceUrl;

  @Override
  public String toString() {
    return "ListenerFriendMessageBO [toUser=" + toUser + ", messageSequence=" + messageSequence + ", pictures="
        + Arrays.toString(pictures) + ", picture=" + picture + ", tips=" + tips + ", tempUin=" + tempUin + ", groupID="
        + groupID + ", video=" + video + ", voiceUrl=" + voiceUrl + ", senderId=" + senderId + ", receiveId="
        + receiveId + ", message=" + message + ", messageType=" + messageType + "]";
  }

  public ListenerVideoBO getVideo() {

    return video;
  }

  public void setVideo(ListenerVideoBO video) {

    this.video = video;
  }

  public String getVoiceUrl() {

    return voiceUrl;
  }

  public void setVoiceUrl(String voiceUrl) {

    this.voiceUrl = voiceUrl;
  }

  public Long getTempUin() {

    return tempUin;
  }

  public void setTempUin(Long tempUin) {

    this.tempUin = tempUin;
  }

  public Long getGroupID() {

    return groupID;
  }

  public void setGroupID(Long groupID) {

    this.groupID = groupID;
  }

  public Long getToUser() {

    return toUser;
  }

  public void setToUser(Long toUser) {

    this.toUser = toUser;
  }

  public Long getMessageSequence() {

    return messageSequence;
  }

  public void setMessageSequence(Long messageSequence) {

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
