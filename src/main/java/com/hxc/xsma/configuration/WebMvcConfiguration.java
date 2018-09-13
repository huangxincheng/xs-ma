package com.hxc.xsma.configuration;

import com.hxc.xsma.handlers.BaseReturnValueHandler;
import com.hxc.xsma.interceptor.BaseInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * Author: huangxincheng
 * <p>
 * <p>
 *     配置WebMvc
 **/
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    /**
     * 配置统一返回值处理
     * @param returnValueHandlers
     */
    @Override
    protected void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
//        returnValueHandlers.add(0, new BaseReturnValueHandler());
        returnValueHandlers.add(new BaseReturnValueHandler());
    }

    /**
     * 配置拦截器
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BaseInterceptor());
    }
}
