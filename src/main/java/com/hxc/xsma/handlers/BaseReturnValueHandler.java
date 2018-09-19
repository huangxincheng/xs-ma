package com.hxc.xsma.handlers;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxc.xsma.annotation.BaseResponseBody;
import com.hxc.xsma.result.BaseResult;
import com.hxc.xsma.utils.RequestContent;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 结果封装类
 */
public class BaseReturnValueHandler implements HandlerMethodReturnValueHandler {

    /**
     * 类似ResponseBody，仅有添加ResultBeanResponseBody注解的method才会触发
     * 类似ResponseBody，仅有添加ResultBeanResponseBody注解的method才会触发
     */
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return (AnnotationUtils.findAnnotation(returnType.getContainingClass(), BaseResponseBody.class) != null || returnType.getMethodAnnotation(BaseResponseBody.class) != null);
    }

    /**
     /**
     * 使用统一的结果封装类ResultInfo，并序列化成json
     */
    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        mavContainer.setRequestHandled(true);
        BaseResult baseResult = new BaseResult<>(BaseResult.RESULT_OK_CODE, BaseResult.RESULT_OK_MSG, returnValue,
                System.currentTimeMillis() - RequestContent.getBaseRequest().getRhead().getRequestTimeMillis());
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        response.addHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter pw = response.getWriter();
        pw.write(JSON.toJSONString(baseResult));
        pw.flush();
    }
}
