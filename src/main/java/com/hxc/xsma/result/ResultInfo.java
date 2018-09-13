package com.hxc.xsma.result;



public class ResultInfo<T> {

    public static final int RESULT_OK_CODE= 0;

    public static String RESULT_OK_MSG = "success";

    private int resultCode;

    private String resultMsg;

    private T data;

    public ResultInfo(int resultCode, String resultMsg, T data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
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
}
