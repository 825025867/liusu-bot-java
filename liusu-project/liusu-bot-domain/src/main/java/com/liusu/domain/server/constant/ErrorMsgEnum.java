
/*
* $Id:$
* Copyright 2020 hebmss.com All rights reserved.
*/

package com.liusu.domain.server.constant;

/**
 * @author water
 * @since 2020.05.13
 */

public enum ErrorMsgEnum {

  // 参数不正确
  PARAM_ERROR_MSG(200, "参数不正确！"),
  // 参数不可为空
  PARAM_ISNULL_ERROR_MSG(201, "参数不可为空！"),
  // 参数个数不正确
  PARAM_NUMBER_ERROR_MSG(202, "参数个数不正确！"),
  // 类型转换失败
  ENTITY_CONVERT_ERROR_MSG(301, "类型转换失败！");

  /** 值 */
  private int errorCode;

  /** 名称 */
  private String errorMsg;

  private ErrorMsgEnum(int code, String msg) {
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
