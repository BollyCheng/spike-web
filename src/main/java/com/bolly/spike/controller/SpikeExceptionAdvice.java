package com.bolly.spike.controller;

import com.bolly.spike.model.dto.SpikeRestfulResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public SpikeRestfulResult handleException(HttpServletRequest request, Exception e) {
        LOGGER.error("Request Failed, URL = {} ", request.getRequestURI());
        LOGGER.error(e.toString(), e);

        return new SpikeRestfulResult(e);
    }


}
