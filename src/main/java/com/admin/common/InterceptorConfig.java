package com.admin.common;

import com.admin.interceptor.RequestIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author lisheng
 * @version InterceptorConfig, v0.1 2018/11/29 10:03
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new RequestIntercept());
        //拦截所有请求
        registration.addPathPatterns("/**")
                //不拦截首页
                .excludePathPatterns("/");
    }

    /**
     * 默认首页配置
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }


}
