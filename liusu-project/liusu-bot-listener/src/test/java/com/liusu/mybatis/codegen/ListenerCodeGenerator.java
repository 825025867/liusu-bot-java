/*
 * $Id:$
 * Copyright 2017 greacesleon.com All rights reserved.
 */
package com.liusu.mybatis.codegen;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * @author Jades.He
 * @since 2017.05.25
 */
public class ListenerCodeGenerator {

  /**
   * @param args
   * @author Jades.He
   * @throws Exception
   * @since 2017.05.25
   */
  public static void main(String[] args) throws Exception {
    List<String> warnings = new ArrayList<String>();
    boolean overwrite = true;
    InputStream fi = ListenerCodeGenerator.class.getResourceAsStream("/com/liusu/mybatis/codegen/generatorConfig.xml");
    ConfigurationParser cp = new ConfigurationParser(warnings);
    Configuration config = cp.parseConfiguration(fi);
    DefaultShellCallback callback = new DefaultShellCallback(overwrite);
    MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
    myBatisGenerator.generate(null);
  }

}
