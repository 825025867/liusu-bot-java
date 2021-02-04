package com.liusu.listener.server.event;

import com.alibaba.fastjson.JSONObject;

/**
 * 监听事件接口
 * 
 * @author LiuSu
 * @since 2021.01.26
 */
public interface ListenerEvent {

  /**
   * 群消息
   * 
   * @param data
   * @author LiuSu
   * @since 2021.01.26
   */
  public void groupMessage(JSONObject data);

  /**
   * 私聊消息
   * 
   * @param data
   * @author LiuSu
   * @since 2021.01.26
   */
  public void friendMessage(JSONObject data);
}
