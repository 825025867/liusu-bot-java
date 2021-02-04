
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.listener.server.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liusu.domain.server.bo.ListenerPictureBO;
import com.liusu.domain.server.bo.ListenerVideoBO;
import com.liusu.domain.server.constant.MsgTypeEnum;
import com.liusu.listener.server.bot.bo.ListenerFriendMessageBO;
import com.liusu.listener.server.bot.bo.ListenerGroupMessageBO;

/**
 * 解析监听数据
 * 
 * @author LiuSu
 * @since 2021.01.27
 */

public class ListenerParseDataUtils {

  /**
   * 解析群消息
   * 
   * @param object
   * @return
   * @author LiuSu
   * @since 2021.01.28
   */
  public static ListenerGroupMessageBO ParseGroupMessage(JSONObject object) {
    ListenerGroupMessageBO groupBO = new ListenerGroupMessageBO();
    groupBO.setReceiveId(object.getLong("CurrentQQ"));
    JSONObject currentPacket = object.getJSONObject("CurrentPacket");
    JSONObject data = currentPacket.getJSONObject("Data");

    groupBO.setMessageType(MsgTypeEnum.of(data.getString("MsgType")));

    groupBO.setGroupNickName(data.getString("FromGroupName"));
    groupBO.setSenderNickName(data.getString("FromNickName"));

    groupBO.setMessageRandom(data.getLong("MsgRandom"));
    groupBO.setGroupID(data.getLong("FromGroupId"));
    groupBO.setSenderId(data.getLong("FromUserId"));
    groupBO.setMessageTime(data.getTimestamp("MsgTime"));
    groupBO.setMessageSequence(data.getLong("MsgSeq"));

    switch (groupBO.getMessageType()) {
      case TEXT_MSG: {
        groupBO.setMessage(data.getString("Content"));
        break;
      }
      case AT_MSG: {
        JSONObject content = data.getJSONObject("Content");
        groupBO.setMessage(content.getString("Content"));
        JSONArray userArray = content.getJSONArray("UserID");
        groupBO.setAtUsers(new Long[userArray.size()]);
        for (int i = 0; i < userArray.size(); i++) {
          groupBO.getAtUsers()[i] = userArray.getLong(i);
        }
        break;
      }
      case PIC_MSG: {
        JSONObject content = data.getJSONObject("Content");
        groupBO.setMessage(content.toString());
        groupBO.setTips(content.getString("Tips"));
        JSONArray pics = content.getJSONArray("GroupPic");
        groupBO.setPictures(new ListenerPictureBO[pics.size()]);
        for (int i = 0; i < pics.size(); i++) {
          JSONObject pic = pics.getJSONObject(i);
          ListenerPictureBO temp = new ListenerPictureBO(pic.getString("Url"), pic.getLong("FileId"),
              pic.getLong("FileSize"), pic.getString("FileMd5"), pic.getString("ForwordBuf"),
              pic.getString("ForwordField"));
          groupBO.getPictures()[i] = temp;
        }
        break;
      }
      case BIG_FACE_MSG: {
        JSONObject content = data.getJSONObject("Content");
        groupBO.setMessage(content.toString());
        groupBO.setBigFace(new ListenerPictureBO(content.getString("ForwordBuf"), content.getString("ForwordField")));
        break;
      }
      case VOICE_MSG: {
        JSONObject content = data.getJSONObject("Content");
        groupBO.setMessage(content.toJSONString());
        groupBO.setTips(content.getString("Tips"));
        groupBO.setVoiceUrl(content.getString("Url"));
        break;
      }
      case VIDEO_MSG: {
        JSONObject content = data.getJSONObject("Content");
        groupBO.setMessage(content.getString("Content"));
        groupBO.setTips(content.getString("Tips"));
        groupBO.setVideo(new ListenerVideoBO(content.getString("videoUrl"), content.getLong("videoSize"),
            content.getString("videoMd5"), content.getString("forwordBuf"), content.getLong("forwordField")));
        break;
      }
      case UNKNOWN_MSG:
        groupBO.setMessage("[此消息类型暂不支持解析]");
        break;
      default:
        groupBO.setMessage("[此消息类型暂不支持解析]");
        break;
    }
    return groupBO;
  }

  /**
   * 解析好友/私聊消息
   * 
   * @param object
   * @return
   * @author LiuSu
   * @since 2021.01.28
   */
  public static ListenerFriendMessageBO ParseFriendMessage(JSONObject object) {
    ListenerFriendMessageBO friendBO = new ListenerFriendMessageBO();

    friendBO.setReceiveId(object.getLong("CurrentQQ"));
    JSONObject currentPacket = object.getJSONObject("CurrentPacket");
    JSONObject data = currentPacket.getJSONObject("Data");

    friendBO.setMessageType(MsgTypeEnum.of(data.getString("MsgType")));
    friendBO.setSenderId(data.getLong("FromUin"));
    friendBO.setToUser(data.getLong("ToUin"));

    switch (friendBO.getMessageType()) {
      case TEXT_MSG: {
        friendBO.setMessage(data.getString("Content"));
        friendBO.setMessageSequence(data.getLong("MsgSeq"));
        break;
      }
      case TEMP_SESSION_MSG: {
        JSONObject content = data.getJSONObject("Content");
        friendBO.setMessage(content.toString());

        //若为纯文本消息则结束
        if (!content.containsKey("FriendPic")) {
          break;
        }
        friendBO.setTips(content.getString("Tips"));
        friendBO.setTempUin(content.getLong("TempUin"));
        friendBO.setGroupID(content.getLong("GroupID"));
        JSONArray pics = content.getJSONArray("FriendPic");
        friendBO.setPictures(new ListenerPictureBO[pics.size()]);
        for (int i = 0; i < pics.size(); i++) {
          JSONObject pic = pics.getJSONObject(i);
          ListenerPictureBO temp = new ListenerPictureBO(pic.getString("Path"), pic.getString("Url"),
              pic.getLong("FileSize"), pic.getString("FileMd5"));
          friendBO.getPictures()[i] = temp;
        }
        break;
      }
      case PIC_MSG: {
        JSONObject content = data.getJSONObject("Content");
        friendBO.setMessage(content.toString());
        friendBO.setTips(content.getString("Tips"));
        friendBO.setMessageSequence(data.getLong("MsgSeq"));
        JSONArray pics = content.getJSONArray("FriendPic");
        friendBO.setPictures(new ListenerPictureBO[pics.size()]);
        for (int i = 0; i < pics.size(); i++) {
          JSONObject pic = pics.getJSONObject(i);
          ListenerPictureBO temp = new ListenerPictureBO(pic.getString("Path"), pic.getString("Url"),
              pic.getLong("FileSize"), pic.getString("FileMd5"));
          friendBO.getPictures()[i] = temp;
        }
        break;
      }
      case BIG_FACE_MSG: {
        JSONObject content = data.getJSONObject("Content");
        friendBO.setMessage(content.toString());
        friendBO.setTips(content.getString("Tips"));
        friendBO.setMessageSequence(data.getLong("MsgSeq"));
        friendBO.setPicture(new ListenerPictureBO(content.getString("ForwordBuf"), content.getString("ForwordField")));
        break;
      }
      case VIDEO_MSG: {
        JSONObject content = data.getJSONObject("Content");
        friendBO.setMessage(content.getString("Content"));
        friendBO.setTips(content.getString("Tips"));
        friendBO.setVideo(new ListenerVideoBO(content.getString("videoUrl"), content.getLong("videoSize"),
            content.getString("videoMd5"), content.getString("forwordBuf"), content.getLong("forwordField")));
        break;
      }
      case VOICE_MSG: {
        JSONObject content = data.getJSONObject("Content");
        friendBO.setMessage(content.toJSONString());
        friendBO.setTips(content.getString("Tips"));
        friendBO.setVoiceUrl(content.getString("Url"));
        break;
      }
      case UNKNOWN_MSG:
        friendBO.setMessage("[此消息类型暂不支持解析]");
        break;
      default:
        friendBO.setMessage("[此消息类型暂不支持解析]");
        break;
    }

    return friendBO;
  }
}
