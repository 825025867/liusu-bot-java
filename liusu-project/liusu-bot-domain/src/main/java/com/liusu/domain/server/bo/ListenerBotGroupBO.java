
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.domain.server.bo;

import java.sql.Timestamp;
import java.util.Arrays;

/**
 * 监听群消息BO
 * 
 * @author LiuSu
 * @since 2021.01.26
 */

public class ListenerBotGroupBO extends ListenerBotBO {

  private static final long serialVersionUID = 7279288227662735044L;

  // 群号(所有消息类型均有)
  private Long groupID;

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
    return "ListenerBotGroupBO [groupID=" + groupID + ", groupNickName=" + groupNickName + ", senderNickName="
        + senderNickName + ", messageSequence=" + messageSequence + ", messageTime=" + messageTime + ", messageRandom="
        + messageRandom + ", atUsers=" + Arrays.toString(atUsers) + ", pictures=" + Arrays.toString(pictures)
        + ", tips=" + tips + ", bigFace=" + bigFace + ", voiceUrl=" + voiceUrl + "]";
  }

  public Long getGroupID() {

    return groupID;
  }

  public void setGroupID(Long groupID) {

    this.groupID = groupID;
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
