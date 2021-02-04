
package com.liusu.send.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.liusu.send.server.text.service.SendTextMsgService;

/**
 * Store的测试类
 * 
 * @author Joan.Liu
 * @since 2020.06.20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SendWebApplication.class)
@Transactional(rollbackFor = Exception.class)
@Rollback(true)
public class JunitStoreTest extends JunitTestBase {

  public final Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  SendTextMsgService service;

  @Test
  @Rollback(false)
  public void save() {
  }
}
