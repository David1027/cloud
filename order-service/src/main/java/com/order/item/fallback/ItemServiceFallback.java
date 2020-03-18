package com.order.item.fallback;

import com.order.item.entity.Item;
import com.order.item.feign.ItemFeignClient;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description: 商品统一容错类
 * @author: lingjian
 * @create: 2020/3/18 20:41
 */
@Component
public class ItemServiceFallback implements ItemFeignClient {

  /**
   * 服务降级的方法要和原方法一致(名称、参数列表)
   *
   * @param id 商品主键
   * @return Item 商品对象
   */
  @Override
  public Item queryItemById(@PathVariable("id") Long id) {
    return new Item(null, "服务降级方法queryItemById", null, "服务降级方法queryItemById", null);
  }
}
