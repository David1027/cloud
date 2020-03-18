package com.order;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(OrderServiceApplication.class)
class OrderServiceApplicationTests {

  @Test
  void contextLoads() {}

  @Autowired
  private LoadBalancerClient loadBalancerClient;//自动注入

  @Test
  public void test() {
    String serviceId = "item-service";
    for (int i = 0; i < 100; i++) {
      ServiceInstance serviceInstance = this.loadBalancerClient.choose(serviceId);
      System.out.println("第" + (i + 1) + "次：" + serviceInstance.getHost() + ": " + serviceInstance.getPort());
    }
  }
}
