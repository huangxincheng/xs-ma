package com.hxc.xsma.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;


public class BaseRequest {

    private BasePhead phead;

    private Map<String,Object> data;

    private BaseRhead rhead;

    /**
     * 内部请求信息
     */
    public static class BasePhead {
        /**
         * 协议版本
         */
        private int pVersion;
        /**
         * 客户端版本
         */
        private String cVersion;

        public int getpVersion() {
            return pVersion;
        }

        public void setpVersion(int pVersion) {
            this.pVersion = pVersion;
        }

        public String getcVersion() {
            return cVersion;
        }

        public void setcVersion(String cVersion) {
            this.cVersion = cVersion;
        }
    }

    /**
     *  通用请求头信息
     */
    public static class BaseRhead {
        /**
         * 请求的Ip
         */
        private String cip;

        public String getCip() {
            return cip;
        }

        public void setCip(String cip) {
            this.cip = cip;
        }
    }
}
