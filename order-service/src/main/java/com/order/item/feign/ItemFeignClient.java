package com.order.item.feign;

import com.order.item.entity.Item;
import com.order.item.fallback.ItemServiceFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description: 商品Feign客户端 - 申明这是一个Feign客户端，并且指明服务id和容错实现类
 * @author: lingjian
 * @create: 2020/3/18 20:25
 */
@FeignClient(value = "item-service", fallback = ItemServiceFallback.class)
public interface ItemFeignClient {

  /**
   * 这里定义了类似于SpringMVC用法的方法，就可以进行RESTful方式的调用了
   *
   * @param id 商品主键
   * @return Item 商品对象
   */
  @GetMapping(value = "/item/{id}")
  Item queryItemById(@PathVariable("id") Long id);
}
