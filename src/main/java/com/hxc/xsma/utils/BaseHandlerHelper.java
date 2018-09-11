package com.hxc.xsma.utils;

import com.hxc.xsma.interceptor.BaseInterceptor;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Author: huangxincheng
 * <p>
 * <p>
 **/
public class BaseHandlerHelper {

    public static void parsingRequest() throws IOException {
        HttpServletRequest request = BaseInterceptor.requestLocal.get();
        String a = request.getParameter("a");
        System.out.println("BaseHandlerHelper a = " + a);

        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String result = IOUtils.toString(reader);
        System.out.println("BaseHandlerHelper result = " + result);
    }

}
