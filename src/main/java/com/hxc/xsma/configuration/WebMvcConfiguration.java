package com.hxc.xsma.configuration;

import com.hxc.xsma.handlers.BaseReturnValueHandler;
import com.hxc.xsma.interceptor.BaseInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.DeferredResultMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: huangxincheng
 * <p>
 * <p>
 *     配置WebMvc
 **/
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;


    @Bean
    public HandlerMethodReturnValueHandler baseReturnValueHandler() {
        return new BaseReturnValueHandler();
    }

    /**
     * 配置统一返回值处理
     * @param returnValueHandlers
     */
//    @Override
//    protected void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
//        returnValueHandlers.add(0, new BaseReturnValueHandler());
//        returnValueHandlers.add(new BaseReturnValueHandler());
//    }

    /**
     * 配置拦截器
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BaseInterceptor());
    }


    @PostConstruct
    public void init() {
        final List<HandlerMethodReturnValueHandler> originalHandlers = new ArrayList<>(
                requestMappingHandlerAdapter.getReturnValueHandlers());

        final int deferredPos = obtainValueHandlerPosition(originalHandlers, DeferredResultMethodReturnValueHandler.class);
        // Add our handler directly after the deferred handler.
        originalHandlers.add(deferredPos + 1, baseReturnValueHandler());

        requestMappingHandlerAdapter.setReturnValueHandlers(originalHandlers);
    }

    private int obtainValueHandlerPosition(final List<HandlerMethodReturnValueHandler> originalHandlers, Class<?> handlerClass) {
        for (int i = 0; i < originalHandlers.size(); i++) {
            final HandlerMethodReturnValueHandler valueHandler = originalHandlers.get(i);
            if (handlerClass.isAssignableFrom(valueHandler.getClass())) {
                return i;
            }
        }
        return -1;
    }
}
