package com.hxc.xsma.result;

import java.util.Map;


public class BaseRequest {

    private BasePhead phead;

    private Map<String,Object> data;

    private BaseRhead rhead;

    public BasePhead getPhead() {
        return phead;
    }

    public void setPhead(BasePhead phead) {
        this.phead = phead;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public BaseRhead getRhead() {
        return rhead;
    }

    public void setRhead(BaseRhead rhead) {
        this.rhead = rhead;
    }

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

        private String X_RealIp;

        private String X_ForwardedFor;

        private Long requestTimeMillis;

        public String getX_RealIp() {
            return X_RealIp;
        }

        public void setX_RealIp(String x_RealIp) {
            X_RealIp = x_RealIp;
        }

        public String getX_ForwardedFor() {
            return X_ForwardedFor;
        }

        public void setX_ForwardedFor(String x_ForwardedFor) {
            X_ForwardedFor = x_ForwardedFor;
        }

        public Long getRequestTimeMillis() {
            return requestTimeMillis;
        }

        public void setRequestTimeMillis(Long requestTimeMillis) {
            this.requestTimeMillis = requestTimeMillis;
        }
    }
}
