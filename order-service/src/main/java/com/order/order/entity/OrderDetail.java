package com.order.order.entity;

import com.order.item.entity.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 订单详情基类
 * @author: lingjian
 * @create: 2020/3/17 19:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

  /** 订单主键 */
  private String orderId;
  /** 商品对象 */
  private Item item;
}
