package com.liusu.listener.server.bot.service;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.hbmss.framework.exception.ServiceException;
import com.liusu.domain.server.constant.ListenerBotCfgConstant;
import com.liusu.domain.server.constant.SendHttpErrorMsgEnum;
import com.liusu.listener.server.event.ListenerLogEvent;
import com.liusu.listener.server.event.ListenerProcessEvent;

import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

/**
 * bot core
 * 
 * @author LiuSu
 * @since 2021.01.26
 */
@Service
public class ListenerBotService {

  public final Logger logger = LoggerFactory.getLogger(getClass());

  private Socket socket;

  /**
   * 启动bot监听
   * 
   * @author LiuSu
   * @since 2021.01.28
   */
  public void startListenerBot() {
    IO.Options options = new IO.Options();
    options.transports = new String[] { "websocket" };
    try {
      socket = IO.socket("http://" + "localhost" + ":" + "8888", options);
    } catch (URISyntaxException e) {
      throw new ServiceException(SendHttpErrorMsgEnum.URL_ERROR_MSG.getErrorMsg(), e);

    }

    socket.on("connect", new Emitter.Listener() {

      @Override
      public void call(Object... args) {
        socket.emit("GetWebConn", String.valueOf(ListenerBotCfgConstant.BOT_QQ), (Ack) args1 -> {
          logger.info("注册完成, 服务器返回: " + args1[0]);
        });
        socket.off("connect", this);
      }
    });
    socket.on("OnFriendMsgs", args -> {
      new ListenerProcessEvent().friendMessage(JSONObject.parseObject(args[0].toString()));
      new ListenerLogEvent().friendMessage(JSONObject.parseObject(args[0].toString()));
    });
    socket.on("OnGroupMsgs", args -> {
      new ListenerProcessEvent().groupMessage(JSONObject.parseObject(args[0].toString()));
      new ListenerLogEvent().groupMessage(JSONObject.parseObject(args[0].toString()));
    });
    //    socket.on("OnEvents",
    //        args -> callEvent(new OtherEvent(this, JsonParser.parseString(args[0].toString()).getAsJsonObject())));
    socket.connect();
    logger.info("正在连接至IOTBot...");
  }

}
