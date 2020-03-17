package com.order.item.service;

import com.order.item.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 商品服务层
 * @author: lingjian
 * @create: 2020/3/17 19:29
 */
@Service
public class ItemService {

  // Spring框架对RESTful方式的http请求做了封装，来简化操作
  @Autowired private RestTemplate restTemplate;

  public Item queryItemById(Long id) {
    // 该方法走eureka注册中心调用(去注册中心根据app-item查找服务，这种方式必须先开启负载均衡@LoadBalanced)
    String itemUrl = "http://item-service/item/{id}";
    Item result = restTemplate.getForObject(itemUrl, Item.class, id);
    System.out.println("订单系统调用商品服务,result:" + result);
    return result;
  }
}
