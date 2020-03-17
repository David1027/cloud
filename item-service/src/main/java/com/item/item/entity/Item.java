package com.item.item.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 商品基类
 * @author: lingjian
 * @create: 2020/3/17 16:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

  /** 主键 */
  private Long id;
  /** 商品标题 */
  private String title;
  /** 商品图片 */
  private String pic;
  /** 商品描述 */
  private String desc;
  /** 商品价格 */
  private Long price;
}
