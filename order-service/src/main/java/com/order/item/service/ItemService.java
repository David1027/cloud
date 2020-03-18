package com.order.item.service;

import javax.annotation.Resource;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.order.item.entity.Item;
import com.order.item.feign.ItemFeignClient;

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
  @Resource private RestTemplate restTemplate;

  /**
   * 根据商品id，查询商品信息
   *
   * @param id 商品主键
   * @return Item 商品对象
   */
  public Item queryItemById(Long id) {
    // 该方法走eureka注册中心调用(去注册中心根据app-item查找服务，这种方式必须先开启负载均衡@LoadBalanced)
    String itemUrl = "http://item-service/item/{id}";
    Item result = restTemplate.getForObject(itemUrl, Item.class, id);
    System.out.println("订单系统调用商品服务,result:" + result);
    return result;
  }

  // 通过Feign客户端
  @Resource private ItemFeignClient itemFeignClient;

  /**
   * 根据商品id，查询商品信息，进行容错处理 fallbackMethod的方法参数个数类型要和原方法一致
   *
   * @param id 商品主键
   * @return Item 商品对象
   */
  public Item queryItemByIdFallback(Long id) {
    Item result = itemFeignClient.queryItemById(id);
    System.out.println(
        "===========HystrixCommand queryItemById-线程池名称："
            + Thread.currentThread().getName()
            + "订单系统调用商品服务,result:"
            + result);
    return result;
  }
}
