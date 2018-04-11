package com.bolly.spike.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 * Author   : Bolly
 * CreateAt : 2018/04/11 21:58:25
 */
@ControllerAdvice
public class SpikeExceptionAdvice {

    private static Logger LOGGER = LoggerFactory.getLogger(SpikeExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(HttpServletRequest request, Exception e) {
        LOGGER.error("Request FAILD, URL = {} ", request.getRequestURI());
        LOGGER.error(e.toString(), e);

        JSONObject jsonResult = new JSONObject();
        jsonResult.put("result", "failed");

        if (e instanceof IllegalArgumentException) {
            jsonResult.put("message", e.getMessage());
        } else {
            jsonResult.put("message", "服务器内部错误。");
        }
        return jsonResult.toJSONString();
    }


}
