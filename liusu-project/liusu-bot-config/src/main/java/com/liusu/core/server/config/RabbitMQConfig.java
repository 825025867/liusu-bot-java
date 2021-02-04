
/*
* $Id:$
* Copyright 2020 hbmisisi.com All rights reserved.
*/

package com.liusu.core.server.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;

/**
 * @author Leon.Dong
 * @since 2020.11.18
 */

public class RabbitMQConfig {

  /** Rabbit MQ config */
  @Bean("jackson2JsonMessageConverter")
  public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }

}
