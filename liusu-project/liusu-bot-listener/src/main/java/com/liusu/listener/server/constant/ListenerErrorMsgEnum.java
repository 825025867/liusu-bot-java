
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.listener.server.constant;

/**
 * listener 错误枚举
 * 
 * @author LiuSu
 * @since 2021.01.26
 */

public enum ListenerErrorMsgEnum {

  /** bot启动失败! */
  BOT_BOOT_FAILURE_ERROR_MSG(1001, "bot启动失败!");

  /** 值 */
  private int errorCode;

  /** 名称 */
  private String errorMsg;

  private ListenerErrorMsgEnum(int code, String msg) {
    this.errorCode = code;
    this.errorMsg = msg;
  }

  public int getErrorCode() {

    return errorCode;
  }

  public String getErrorMsg() {

    return errorMsg;
  }

}
