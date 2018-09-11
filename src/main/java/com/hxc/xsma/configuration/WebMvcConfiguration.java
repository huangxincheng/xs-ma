package com.hxc.xsma.configuration;

import com.hxc.xsma.interceptor.BaseInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Author: huangxincheng
 * <p>
 * <p>
 *     配置WebMvc
 **/
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {


    /**
     *
     *
     * 增加拦截器
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BaseInterceptor());
    }
}
