/*
 * $Id:$
 * Copyright 2017 ecarpo.com All rights reserved.
 */
package com.liusu.send.server;

import java.util.Date;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.hbmss.framework.jdbc.keygen.KeyGenerator;
import com.hbmss.framework.model.InsertDTO;
import com.hbmss.framework.model.UpdateDTO;

/**
 * @author Jades.He
 * @since 2017.05.26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SendWebApplication.class)
@Transactional(rollbackFor = Exception.class)
@Rollback(true)
public class JunitTestBase {

  public final Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private KeyGenerator keyGenerator;

  protected Long getId() {
    return keyGenerator.generateKey().longValue();
  }

  protected void initial(InsertDTO dto) {
    dto.setCreateTime(new Date());
    dto.setCreatorId(1L);
    dto.setCreatorName("1");
    dto.setModifyTime(new Date());
    dto.setModifierId(1L);
    dto.setModifierName("1");
    dto.setDelFlag(0);
  }

  protected void initial(UpdateDTO dto) {
    dto.setModifyTime(new Date());
    dto.setModifierId(1L);
    dto.setModifierName("1");
  }

  protected void print(Object o) throws Exception {
    logger.debug("####################################");
    if (o != null) {
      String json = JSON.toJSONString(o);
      logger.debug("data: {}", json);
    } else {
      logger.debug("data: is null");
    }
    logger.debug("####################################");
  }

}
