package com.example.interceptor.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * preHandle() : 맵핑되기 전 처리
 * postHandle() : 맵핑된 후 처리
 * afterCompletion() : 모든 작업이 완료된 후 실행
 */

@Component
public class HttpInterceptor implements HandlerInterceptor {

  private static final Logger logger = LoggerFactory.getLogger(HttpInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler) {
    logger.info("### Before Method");
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request,
                         HttpServletResponse response,
                         Object handler,
                         ModelAndView modelAndView) {
    logger.info("### Method Executed");
  }

  @Override
  public void afterCompletion(HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler,
                              Exception ex) {
    logger.info("### Method Completed");
  }

}
