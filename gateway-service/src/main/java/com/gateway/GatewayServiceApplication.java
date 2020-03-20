package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * @description: 服务网关启动项
 * @author: lingjian
 * @create: 2020/3/19 9:36
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(GatewayServiceApplication.class, args);
  }

  @RefreshScope
  @ConfigurationProperties("zuul")
  public ZuulProperties zuulProperties() {
    ZuulProperties properties = new ZuulProperties();
    System.out.println("properties:" + properties);
    return properties;
  }
}
