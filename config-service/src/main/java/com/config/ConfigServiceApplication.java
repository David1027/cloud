package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description: 配置中心服务端启动项
 * @author: lingjian
 * @create: 2020/3/19 10:40
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConfigServiceApplication.class, args);
  }
}
