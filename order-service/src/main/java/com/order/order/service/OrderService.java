package com.order.order.service;

import java.util.*;

import javax.annotation.Resource;

import com.order.item.entity.Item;
import com.order.item.service.ItemService;
import com.order.order.entity.Order;
import com.order.order.entity.OrderDetail;

import org.springframework.stereotype.Service;

/**
 * @description: 订单服务层
 * @author: lingjian
 * @create: 2020/3/17 19:27
 */
@Service
public class OrderService {

  private static final Map<String, Order> ORDER_DATA = new HashMap<String, Order>();

  static {
    // 模拟数据库，构造测试数据
    Order order = new Order();
    order.setOrderId("20200317001");
    order.setCreateDate(new Date());
    order.setUpdateDate(order.getCreateDate());
    order.setUserId(1L);
    List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

    // 此处并没有商品的数据，只是保存了商品ID，需要调用商品微服务获取
    Item item = new Item();
    item.setId(1L);
    orderDetails.add(new OrderDetail(order.getOrderId(), item));

    // 构造第二个商品数据
    item = new Item();
    item.setId(2L);
    orderDetails.add(new OrderDetail(order.getOrderId(), item));

    order.setOrderDetails(orderDetails);

    ORDER_DATA.put(order.getOrderId(), order);
  }

  @Resource private ItemService itemService;

  /**
   * 根据订单id查询订单数据
   *
   * @param orderId 订单主键
   * @return Order 订单对象
   */
  public Order queryOrderById(String orderId) {
    Order order = ORDER_DATA.get(orderId);
    if (null == order) {
      return null;
    }
    List<OrderDetail> orderDetails = order.getOrderDetails();
    for (OrderDetail orderDetail : orderDetails) {
      // 通过商品微服务查询商品详细数据
      Item item = this.itemService.queryItemById(orderDetail.getItem().getId());
      if (null == item) {
        continue;
      }
      orderDetail.setItem(item);
    }
    return order;
  }

  /**
   * 根据订单id查询订单数据
   *
   * @param orderId 订单主键
   * @return Order 订单对象
   */
  public Order queryOrderByIdFallback(String orderId) {
    Order order = ORDER_DATA.get(orderId);
    if (null == order) {
      return null;
    }
    List<OrderDetail> orderDetails = order.getOrderDetails();
    for (OrderDetail orderDetail : orderDetails) {
      // 通过商品微服务查询商品详细数据
      Item item = this.itemService.queryItemByIdFallback(orderDetail.getItem().getId());
      if (null == item) {
        continue;
      }
      orderDetail.setItem(item);
    }
    return order;
  }
}
