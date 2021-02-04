package com.liusu.pd.server.process.dto;

import com.liusu.domain.server.bo.ListenerPictureBO;

import java.sql.Timestamp;
import java.util.Arrays;

/**
 * 监听群组消息DTO实体
 * 
 * @author LiuSu
 * @since 2021.01.27
 */
public class PdProcessGroupDTO extends PdProcessBaseDTO {

  private static final long serialVersionUID = -6010250454389123236L;

  // 群号(所有消息类型均有)
  private Long groupId;

  // 群名称(所有消息类型均有)
  private String groupNickName;

  // 发送者群名片(所有消息类型均有)
  private String senderNickName;

  // 消息顺序号(所有消息类型均有)
  private Long messageSequence;

  // 消息发送时间(所有消息类型均有)
  private Timestamp messageTime;

  // 消息随机码(所有消息类型均有)
  private Long messageRandom;

  //@ 到的用户ID(AtMsg)
  private Long[] atUsers;

  //消息中的图片(PicMsg)
  private ListenerPictureBO[] pictures;

  //非文本消息的表示形式(AtMsg,PicMsg,BigFaceMsg,VoiceMsg)
  private String tips;

  //消息中的大表情，其中的参数不完整，只有ForwordBuf和ForwordField(BigFaceMsg)
  private ListenerPictureBO bigFace;

  //语音消息的url(VoiceMsg)
  private String voiceUrl;

  @Override
  public String toString() {
    return "ListenerGroupMessageDTO [groupId=" + groupId + ", groupNickName=" + groupNickName + ", senderNickName="
        + senderNickName + ", messageSequence=" + messageSequence + ", messageTime=" + messageTime + ", messageRandom="
        + messageRandom + ", atUsers=" + Arrays.toString(atUsers) + ", pictures=" + Arrays.toString(pictures)
        + ", tips=" + tips + ", bigFace=" + bigFace + ", voiceUrl=" + voiceUrl + ", senderId=" + senderId
        + ", receiveId=" + receiveId + ", message=" + message + ", messageType=" + messageType + "]";
  }

  public Long getGroupID() {

    return groupId;
  }

  public void setGroupID(Long groupId) {

    this.groupId = groupId;
  }

  public String getGroupNickName() {

    return groupNickName;
  }

  public void setGroupNickName(String groupNickName) {

    this.groupNickName = groupNickName;
  }

  public String getSenderNickName() {

    return senderNickName;
  }

  public void setSenderNickName(String senderNickName) {

    this.senderNickName = senderNickName;
  }

  public Long getMessageSequence() {

    return messageSequence;
  }

  public void setMessageSequence(Long messageSequence) {

    this.messageSequence = messageSequence;
  }

  public Timestamp getMessageTime() {

    return messageTime;
  }

  public void setMessageTime(Timestamp messageTime) {

    this.messageTime = messageTime;
  }

  public Long getMessageRandom() {

    return messageRandom;
  }

  public void setMessageRandom(Long messageRandom) {

    this.messageRandom = messageRandom;
  }

  public Long[] getAtUsers() {

    return atUsers;
  }

  public void setAtUsers(Long[] atUsers) {

    this.atUsers = atUsers;
  }

  public ListenerPictureBO[] getPictures() {

    return pictures;
  }

  public void setPictures(ListenerPictureBO[] pictures) {

    this.pictures = pictures;
  }

  public String getTips() {

    return tips;
  }

  public void setTips(String tips) {

    this.tips = tips;
  }

  public ListenerPictureBO getBigFace() {

    return bigFace;
  }

  public void setBigFace(ListenerPictureBO bigFace) {

    this.bigFace = bigFace;
  }

  public String getVoiceUrl() {

    return voiceUrl;
  }

  public void setVoiceUrl(String voiceUrl) {

    this.voiceUrl = voiceUrl;
  }

}
