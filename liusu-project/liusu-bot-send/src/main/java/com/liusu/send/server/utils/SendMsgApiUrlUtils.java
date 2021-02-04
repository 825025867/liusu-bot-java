
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.send.server.utils;

/**
 * 发送消息Api地址工具类
 * 
 * @author LiuSu
 * @since 2021.01.28
 */

public class SendMsgApiUrlUtils {

  /**
   * 文本消息
   * 
   * @param location
   * @param port
   * @param qq
   * @param funcname
   * @return
   * @author LiuSu
   * @since 2021.01.28
   */
  public static String textMsgUrl(String location, int port, long qq, String funcname) {
    return textMsgUrl_v2(location, port, qq, funcname);
  }

  /**
   * SendMsgV2 文本消息
   * 
   * @param location
   * @param port
   * @param qq
   * @param funcname
   * @return
   * @author LiuSu
   * @since 2021.01.28
   */
  private static String textMsgUrl_v2(String location, int port, long qq, String funcname) {
    String url = " http://" + location + ":" + port + "/v1/LuaApiCaller?qq=" + qq + "&funcname=" + funcname;
    return url;
  }
}
