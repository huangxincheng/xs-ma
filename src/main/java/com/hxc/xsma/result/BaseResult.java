package com.hxc.xsma.result;



public class BaseResult<T> {

    public static final int RESULT_OK_CODE= 0;

    public static String RESULT_OK_MSG = "success";

    private int resultCode;

    private String resultMsg;

    private Long resultTimeMillis;

    private T data;

    public BaseResult(int resultCode, String resultMsg, T data, Long resultTimeMillis) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
        this.resultTimeMillis = resultTimeMillis;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getResultTimeMillis() {
        return resultTimeMillis;
    }

    public void setResultTimeMillis(Long resultTimeMillis) {
        this.resultTimeMillis = resultTimeMillis;
    }
}
