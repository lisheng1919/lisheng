package com.admin.interceptor;


import com.admin.exception.ReturnMessageException;
import com.admin.response.Response;
import com.admin.vo.BaseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lisheng
 * @version GlobalExceptionHandler, v0.1 2018/11/29 10:39
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Response<BaseVO> defaultErrorHandler(HttpServletRequest req, Exception e) {
        log.error("请求路径:[{}]",req.getRequestURI());
        log.error("system error", e);
        Response<BaseVO> response = new Response<BaseVO>();
        response.setRtn(Response.ERROR);
        response.setMessage(e.getMessage() == null ? Response.ERROR_MSG : e.getMessage());
        return response;
    }

    @ExceptionHandler(value = ReturnMessageException.class)
    public Response<BaseVO> defaultReturnErrorHandler(HttpServletRequest req, ReturnMessageException e) {
        log.error("请求路径:[{}]",req.getRequestURI());
        Response<BaseVO> response = new Response<BaseVO>();
        response.setRtn(e.getCode());
        response.setMessage(e.getMsg());
        return response;
    }
}
