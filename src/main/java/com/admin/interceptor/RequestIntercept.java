package com.admin.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author lisheng
 * @version RequestIntercept, v0.1 2018/11/29 10:02
 */
@Slf4j
public class RequestIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("RequestIntercept:"+request.getRequestURL());
        log.info("request.getParameter:{}",request.getParameter("name"));
        if (handler instanceof HandlerMethod) {
            HandlerMethod methodHandle = (HandlerMethod) handler;
            RequestAnnotation methodAnnotation = methodHandle.getMethodAnnotation(RequestAnnotation.class);
            if (methodAnnotation != null) {
                log.info("RequestAnnotation-key:{},-value:{}",methodAnnotation.key(),methodAnnotation.value());
            }
        }
        return true;
    }
}
