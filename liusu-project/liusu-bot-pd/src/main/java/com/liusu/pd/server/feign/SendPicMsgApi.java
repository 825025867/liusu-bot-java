
package com.liusu.pd.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hbmss.framework.model.ResultDTO;
import com.liusu.domain.server.dto.SendPicMsgDTO;

/**
 * 发送图片消息Api
 * 
 * @author LiuSu
 * @since 2021.01.27
 */
@FeignClient("liusu-bot-send-web")
@RequestMapping("/api/send/pic/Msg")
public interface SendPicMsgApi {

  /**
   * 发送群文本消息
   * 
   * @param dto
   * @return
   * @author LiuSu
   * @since 2021.01.27
   */
  @RequestMapping(value = "/groupMsg", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResultDTO<String> groupMsg(@RequestBody SendPicMsgDTO dto);

  /**
   * 发送好友文本消息
   * 
   * @param dto
   * @return
   * @author LiuSu
   * @since 2021.01.27
   */
  @RequestMapping(value = "/friendMsg", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResultDTO<String> friendMsg(@RequestBody SendPicMsgDTO dto);

  /**
   * 发送临时会话文本消息
   * 
   * @param dto
   * @return
   * @author LiuSu
   * @since 2021.01.27
   */
  @RequestMapping(value = "/tempSessionMsg", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResultDTO<String> tempSessionMsg(@RequestBody SendPicMsgDTO dto);

}
