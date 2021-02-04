
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.send.server.constant;

/**
 * 消息发送类型
 * 
 * @author LiuSu
 * @since 2021.01.27
 */

public enum SendToTypeEnum {

  /** 好友消息 */
  FRIEND((short) 1, "好友消息"),
  /** 群聊消息 */
  GROUP((short) 2, "群聊消息"),
  /** 私聊消息 */
  PRIVATE((short) 3, "私聊消息");

  /** 值 */
  private short value;

  /** 名称 */
  private String name;

  private SendToTypeEnum(short value, String name) {
    this.value = value;
    this.name = name;
  }

  /**
   * @return the value
   */
  public short getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(short value) {
    this.value = value;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
}
