package com.liusu.listener.server.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.liusu.domain.server.utils.HttpUtils;
import com.liusu.listener.server.bot.bo.ListenerFriendMessageBO;
import com.liusu.listener.server.bot.bo.ListenerGroupMessageBO;
import com.liusu.listener.server.utils.ListenerParseDataUtils;

/**
 * 处理消息
 * 
 * @author LiuSu
 * @since 2021.01.28
 */
public class ListenerProcessEvent implements ListenerEvent {

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
    HttpUtils.post("http://localhost:9082/api/pd/process/groupMsg", JSONObject.toJSONString(message));
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
    HttpUtils.post("http://localhost:9082/api/pd/process/friendMsg", JSONObject.toJSONString(message));
  }
}
