package com.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description: 商品启动项
 * @author: lingjian
 * @create: 2020/3/17 19:32
 */
@SpringBootApplication
@EnableEurekaClient
public class ItemServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ItemServiceApplication.class, args);
  }
}
