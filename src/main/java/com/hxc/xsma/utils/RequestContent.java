package com.hxc.xsma.utils;

import com.hxc.xsma.result.BaseRequest;

/**
 * Author: huangxincheng
 * <p>
 * <p>
 **/
public class RequestContent {

    public static final ThreadLocal<BaseRequest> baseRequestLocal = new ThreadLocal<>();


    /**
     * 获取存放在线程中的请求信息
     * @return
     */
    public static BaseRequest getBaseRequest() {
        return baseRequestLocal.get();
    }
}
