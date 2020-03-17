package com.order.order.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 订单基类
 * @author: lingjian
 * @create: 2020/3/17 19:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  /** 订单主键 */
  private String orderId;
  /** 用户主键 */
  private Long userId;
  /** 创建时间 */
  private Date createDate;
  /** 更新时间 */
  private Date updateDate;
  /** 订单详情列表 */
  private List<OrderDetail> orderDetails;
}
