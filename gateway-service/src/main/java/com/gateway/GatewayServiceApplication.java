package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

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
}
