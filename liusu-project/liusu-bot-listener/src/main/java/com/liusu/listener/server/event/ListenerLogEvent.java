package com.liusu.listener.server.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.liusu.listener.server.bot.bo.ListenerFriendMessageBO;
import com.liusu.listener.server.bot.bo.ListenerGroupMessageBO;
import com.liusu.listener.server.utils.ListenerParseDataUtils;

/**
 * 消息日志
 * 
 * @author LiuSu
 * @since 2021.01.28
 */
public class ListenerLogEvent implements ListenerEvent {

  public final Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * (non-Javadoc)
   * 
   * @see com.liusu.listener.server.event.ListenerEvent#groupMessage(com.alibaba.fastjson.JSONObject)
   */
  @Override
  public void groupMessage(JSONObject data) {
    ListenerGroupMessageBO message = ListenerParseDataUtils.ParseGroupMessage(data);
    //    logger.debug("······群聊消息······");
    //    logger.debug("解析前········:{}", data.toString());
    //    logger.debug("解析后········:{}", message.toString());
    logger.debug("群聊······{}····{}：    {}", message.getGroupNickName(), message.getSenderNickName(),
        message.getMessage());

  }

  /**
   * (non-Javadoc)
   * 
   * @see com.liusu.listener.server.event.ListenerEvent#friendMessage(com.alibaba.fastjson.JSONObject)
   */
  @Override
  public void friendMessage(JSONObject data) {
    ListenerFriendMessageBO message = ListenerParseDataUtils.ParseFriendMessage(data);
    //    logger.debug("······私聊消息······");
    //    logger.debug("解析前········:{}", data.toString());
    //    logger.debug("解析后········:{}", message.toString());
    logger.debug("私聊······:{}:   {}", message.getSenderId(), message.getMessage());
  }
}
