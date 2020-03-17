package com.order.order.controller;

import javax.annotation.Resource;

import com.order.order.entity.Order;
import com.order.order.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 订单控制层
 * @author: lingjian
 * @create: 2020/3/17 19:33
 */
@RestController
@Api(tags = "订单控制层")
public class OrderController {

  @Resource private OrderService orderService;

  /**
   * 根据订单id，查询订单信息
   *
   * @param orderId 订单id
   * @return Order 订单对象
   */
  @ApiOperation(value = "根据订单id查询订单信息", notes = "案例订单id: 20200317001")
  @GetMapping("order/{orderId}")
  public Order queryOrderById(@PathVariable("orderId") String orderId) {
    return orderService.queryOrderById(orderId);
  }
}
