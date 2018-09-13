package com.hxc.xsma.configuration;

import com.hxc.xsma.handlers.BaseReturnValueHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: huangxincheng
 * <p>
 * <p>
 **/
@Configuration
public class WebApplicationAwareConfiguration implements ApplicationContextAware {

    @Bean
    public HandlerMethodReturnValueHandler baseReturnValueHandler() {
        return new BaseReturnValueHandler();
    }


    /*
     * 注册到容器,采用这种注册方式的目的:
     * 自定义的HandlerMethodReturnValueHandler放在默认实现的前面,从而优先采用自定义处理策略
     * 否则,无法覆盖@ResponseBody处理机制,且String类型的返回值将默认由ViewNameMethodReturnValueHandler处理而映射为视图名
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        RequestMappingHandlerAdapter handlerAdapter = applicationContext.getBean(RequestMappingHandlerAdapter.class);
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<HandlerMethodReturnValueHandler>();
        handlers.add(this.baseReturnValueHandler());
        handlers.addAll(handlerAdapter.getReturnValueHandlers());
        handlerAdapter.setReturnValueHandlers(handlers);
    }
}
