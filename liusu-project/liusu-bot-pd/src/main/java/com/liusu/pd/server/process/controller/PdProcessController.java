package com.liusu.pd.server.process.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hbmss.framework.model.ResultDTO;
import com.hbmss.framework.mvc.controller.BaseController;
import com.liusu.pd.server.process.dto.PdProcessFriendDTO;
import com.liusu.pd.server.process.dto.PdProcessGroupDTO;

/**
 * 处理监听消息
 * 
 * @author LiuSu
 * @since 2021.01.27
 */
@RestController
@RequestMapping(value = "/api/pd/process")
public class PdProcessController extends BaseController {

  @Autowired
  PdProcessBiz biz;

  /**
   * 处理群聊消息
   * 
   * @param dto
   * @return
   * @throws Exception
   * @author LiuSu
   * @since 2021.01.27
   */
  @RequestMapping(value = "/groupMsg", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResultDTO<Boolean> groupMsg(@RequestBody PdProcessGroupDTO dto) throws Exception {
    return biz.groupMsg(dto);
  }

  /**
   * 处理私聊消息
   * 
   * @param dto
   * @return
   * @throws Exception
   * @author LiuSu
   * @since 2021.01.28
   */
  @RequestMapping(value = "/friendMsg", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResultDTO<Boolean> friendMsg(@RequestBody PdProcessFriendDTO dto) throws Exception {
    return biz.friendMsg(dto);
  }
}
