
 
 /*
 * $Id:$
 * Copyright 2021 LiuSu.com All rights reserved.
 */
 
package com.liusu.domain.server.bo;

import com.hbmss.framework.model.BaseModel;
import com.liusu.domain.server.constant.MsgTypeEnum;


/**
 * 
 * @author LiuSu
 * @since 2021.01.26
 */

public class ListenerBotBO extends BaseModel {


   
  private static final long serialVersionUID = -6288479992319066572L;

  // 发送者ID
  protected long senderID;

  // 接收者QQ
  protected long CurrentQQ;

  // 消息内容
  protected String message;

  // 消息类型
  protected MsgTypeEnum messageType;
}

