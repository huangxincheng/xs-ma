package com.hxc.xsma.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxc.xsma.annotation.BaseResponseBody;
import com.hxc.xsma.result.BaseResult;
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
        BaseResult baseResult = new BaseResult<>(BaseResult.RESULT_OK_CODE, BaseResult.RESULT_OK_MSG, returnValue);
        HttpServletResponse response = webRequest.getNativeRequest(HttpServletResponse.class);
        response.addHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter pw = response.getWriter();
        pw.write(new ObjectMapper().writeValueAsString(baseResult));
        pw.flush();
    }
}
