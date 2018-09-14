package com.hxc.xsma.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseRequest {

    private BasePhead phead;

    @Getter
    @Setter
    @ToString
    static class BasePhead {
        /**
         * 协议版本
         */
        private int pVersion;
        /**
         * 客户端版本
         */
        private String cVersion;
        /**
         * 请求IP
         */
        private String cIp;
    }
}
