package com.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @description: 网关过滤器
 * @author: lingjian
 * @create: 2020/3/19 9:53
 */
@Component
public class UserLoginZuulFilter extends ZuulFilter {
  /**
   * 设置过滤器类型为: 1.pre: 请求在被路由之前执行 2.routing: 在路由请求时调用 3.post: 在routing和errror过滤器之后调用 4.error:
   * 处理请求时发生错误调用
   *
   * @return String 过滤器类型
   */
  @Override
  public String filterType() {
    return "pre";
  }

  /**
   * 设置过滤器的执行顺序 - 通过返回的int值来定义过滤器的执行顺序，数字越小优先级越高。
   *
   * @return int
   */
  @Override
  public int filterOrder() {
    return 0;
  }

  /**
   * 设置过滤器是否执行 - 返回一个Boolean值，判断该过滤器是否需要执行。返回true执行，返回false不执行。
   *
   * @return boolean
   */
  @Override
  public boolean shouldFilter() {
    return true;
  }

  /**
   * 过滤器的具体业务逻辑
   *
   * @return Object 对象
   * @throws ZuulException
   */
  @Override
  public Object run() throws ZuulException {
    RequestContext requestContext = RequestContext.getCurrentContext();
    HttpServletRequest request = requestContext.getRequest();
    String token = request.getParameter("token");
    if (StringUtils.isEmpty(token)) {
      // 过滤该请求，不对其进行路由
      requestContext.setSendZuulResponse(false);
      // 设置响应状态码
      requestContext.setResponseStatusCode(401);
      // 设置错误信息提示
      requestContext.setResponseBody(" token is empty!!");
      return null;
    }
    return null;
  }
}
