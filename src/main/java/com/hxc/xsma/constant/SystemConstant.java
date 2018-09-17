package com.hxc.xsma.constant;

/**
 * Author: huangxincheng
 * <p>
 * <p>
 **/
public interface SystemConstant {

    /**
     * 默认的系统编码UTF-8
     */
    String defaultCharacterEncoding = "UTF-8";

    /**
     * 一般来说，X-Forwarded-For是用于记录代理信息的，每经过一级代理(匿名代理除外)，代理服务器都会把这次请求的来源IP追加在X-Forwarded-For中
     * 来自4.4.4.4的一个请求，header包含这样一行
     * X-Forwarded-For: 1.1.1.1, 2.2.2.2, 3.3.3.3
     * 代表 请求由1.1.1.1发出，经过三层代理，第一层是2.2.2.2，第二层是3.3.3.3，而本次请求的来源IP4.4.4.4是第三层代理
     */
    String HEAD_X_Forwarded_For = "X-Forwarded-For";

    /**
     * 而X-Real-IP，没有相关标准，上面的例子，如果配置了X-Read-IP，可能会有两种情况
     * // 最后一跳是正向代理，可能会保留真实客户端IP
     * X-Real-IP: 1.1.1.1
     * // 最后一跳是反向代理，比如Nginx，一般会是与之直接连接的客户端IP
     * X-Real-IP: 3.3.3.3
     * 所以 ，如果只有一层代理，这两个头的值就是一样的
     */
    String HEAD_X_Real_IP = "X-Real-IP";
}
