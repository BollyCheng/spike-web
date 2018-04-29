package com.bolly.spike.model.dto;

/**
 * Author   : Bolly
 * CreateAt : 2018/04/29 15:16:10
 */
public class SpikeRestfulResult {

    public static final String RESULT_SUCCESS = "success";
    public static final String RESULT_FAILED = "failed";

    private String result;
    private String message;
    private Object data;

    public SpikeRestfulResult(Exception e) {
        this.result = RESULT_FAILED;
        if (e instanceof IllegalArgumentException) {
            this.message = e.getMessage();
        } else {
            this.message = "服务器内部错误。";
        }
    }

    public SpikeRestfulResult(Object data) {
        this.result = RESULT_SUCCESS;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
