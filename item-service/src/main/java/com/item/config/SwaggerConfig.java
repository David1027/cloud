package com.item.config;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: 接口文档生成配置中心
 * @author: lingjian
 * @create: 2020/3/17 16:36
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
  /**
   * 配置docket以配置swagger具体参数 Docket swagger-ui界面信息 apiInfo(apiInfo()) 扫描范围
   * apis(RequestHandlerSelectors.basePackage("com.shoestp.demo")) 正则过滤 paths(PathSelectors.any())
   * 忽略参数 ignoredParameterTypes(HttpSession.class) 控制swagger-ui界面展示 enable(isEnable) Boolean
   */
  @Bean
  public Docket docket(Environment environment) {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.item"))
        .paths(PathSelectors.any())
        .build()
        .ignoredParameterTypes(HttpSession.class);
  }

  /**
   * swagger界面基础信息配置
   *
   * @return ApiInfo
   */
  private ApiInfo apiInfo() {
    Contact contact = new Contact("David", "david.com", "123@qq.com");
    return new ApiInfo(
        "商品微服务接口文档",
        "商品模块的微服务项目",
        "v1.0",
        "http://localhost:8080/",
        contact,
        "",
        "",
        new ArrayList<>());
  }
}
