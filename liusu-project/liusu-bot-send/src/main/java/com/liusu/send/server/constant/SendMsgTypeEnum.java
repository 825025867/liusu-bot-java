
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.send.server.constant;

/**
 * 消息类型枚举
 * 
 * @author LiuSu
 * @since 2021.01.27
 * @description 消息类型。[G]:只支持群消息，[F]:只支持好友消息，[FG]:支持群消息和好友消息，未注明表示暂未支持解析
 */

public enum SendMsgTypeEnum {

  /** 纯文本消息[FG] */
  TEXT_MSG(1, "TextMsg", "纯文本消息"),
  /** 图片消息[FG] */
  PIC_MSG(2, "PicMsg", "图片消息"),
  /** 语音消息[G] */
  VOICE_MSG(3, "VoiceMsg", "语音消息"),
  /** obj消息(XML/JSON) */
  XML_MSG(4, "XmlMsg", "obj消息(XML/JSON)"),
  /** 转发消息 */
  FORWORD_MSG(5, "ForwordMsg", "转发消息"),
  /** 回复消息 */
  REPLAY_MSG(6, "ReplayMsg", "回复消息");

  /** 值 */
  private int value;

  /** code */
  private String code;

  /** 名称 */
  private String name;

  private SendMsgTypeEnum(int value, String code, String name) {
    this.value = value;
    this.code = code;
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getCode() {

    return code;
  }

  public void setCode(String code) {

    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
