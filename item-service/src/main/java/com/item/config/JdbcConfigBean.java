package com.item.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @description: 数据库连接对象
 * @author: lingjian
 * @create: 2020/3/19 10:50
 */
@Data
@Component
@RefreshScope
public class JdbcConfigBean {

  /** 数据库连接url */
  @Value("${spring.datasource.url}")
  private String url;
  /** 数据库用户名 */
  @Value("${spring.datasource.username}")
  private String username;
  /** 数据库密码 */
  @Value("${spring.datasource.password}")
  private String password;
  /** 数据库驱动 */
  @Value("${spring.datasource.driver-class-name}")
  private String driverClassName;
}
