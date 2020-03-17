package com.item.item.controller;

import javax.annotation.Resource;

import com.item.item.entity.Item;
import com.item.item.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 商品控制层
 * @author: lingjian
 * @create: 2020/3/17 16:46
 */
@RestController
@Api(tags = "商品相关api")
public class ItemController {

  @Resource private ItemService itemService;

  /**
   * 对外提供接口服务，查询商品信息
   *
   * @param id 商品主键
   * @return Item 商品对象
   */
  @ApiOperation("根据商品id查询商品信息")
  @GetMapping("item/{id}")
  public Item queryItemById(@PathVariable("id") Long id) {
    return itemService.queryItemById(id);
  }
}
