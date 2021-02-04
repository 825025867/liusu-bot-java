package com.liusu.send.server.text.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hbmss.framework.model.ResultDTO;
import com.hbmss.framework.mvc.controller.BaseController;
import com.liusu.domain.server.dto.SendTextMsgDTO;

/**
 * 发送纯文本消息
 * 
 * @author LiuSu
 * @since 2021.01.27
 */
@RestController
@RequestMapping(value = "/api/send/text/Msg")
public class SendTextMsgController extends BaseController {

  @Autowired
  private SendTextMsgBiz biz;

  /**
   * 发送群消息
   * 
   * @param dto
   * @return
   * @throws Exception
   * @author LiuSu
   * @since 2021.01.27
   */
  @RequestMapping(value = "/groupMsg", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResultDTO<String> groupMsg(@RequestBody SendTextMsgDTO dto) throws Exception {
    return biz.groupMsg(dto);
  }

  /**
   * 发送好友消息
   * 
   * @param dto
   * @return
   * @throws Exception
   * @author LiuSu
   * @since 2021.01.27
   */
  @RequestMapping(value = "/friendMsg", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResultDTO<String> friendMsg(@RequestBody SendTextMsgDTO dto) throws Exception {
    return biz.friendMsg(dto);
  }

  /**
   * 发送临时会话消息
   * 
   * @param dto
   * @return
   * @throws Exception
   * @author LiuSu
   * @since 2021.01.27
   */
  @RequestMapping(value = "/tempSessionMsg", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResultDTO<String> tempSessionMsg(@RequestBody SendTextMsgDTO dto) throws Exception {
    return biz.tempSessionMsg(dto);
  }
}
