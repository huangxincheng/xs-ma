package com.hxc.xsma.utils;

import com.hxc.xsma.constant.SystemConstant;
import com.hxc.xsma.result.BaseRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: huangxincheng
 * <p>
 * <p>
 **/
public class BaseRequestHelper {

    /**
     *
     */
    public static void seClientInfo(BaseRequest baseRequest, HttpServletRequest request, Long requestTimeMillis) {
        if (baseRequest == null) {
            baseRequest = new BaseRequest();
        }
        if (baseRequest.getRhead() == null) {
            baseRequest.setRhead(new BaseRequest.BaseRhead());
        }
        baseRequest.getRhead().setX_RealIp(request.getHeader(SystemConstant.HEAD_X_Real_IP));
        baseRequest.getRhead().setX_ForwardedFor(request.getHeader(SystemConstant.HEAD_X_Forwarded_For));
        baseRequest.getRhead().setRequestTimeMillis(requestTimeMillis);
    }
}
