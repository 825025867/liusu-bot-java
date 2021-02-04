
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.domain.server.constant;

/**
 * 发送消息错误枚举
 * 
 * @author LiuSu
 * @since 2021.01.27
 */

public enum SendHttpErrorMsgEnum {

  /** 请求失败! */
  REQUEST_ERROR_MSG(1101, "请求失败!"),
  /** 响应解析失败! */
  RESPONSE_RESOLVE_ERROR_MSG(1102, "响应解析失败!"),
  /** url转换失败! */
  URL_ERROR_MSG(1103, "url转换失败!");

  /** 值 */
  private int errorCode;

  /** 名称 */
  private String errorMsg;

  private SendHttpErrorMsgEnum(int code, String msg) {
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
