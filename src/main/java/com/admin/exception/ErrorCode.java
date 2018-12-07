package com.admin.exception;

/**
 * @author lisheng
 * @version ErrorCode, v0.1 2018/11/30 15:13
 */

public interface ErrorCode {
    /**
     * 获取错误码
     * @return
     */
    String getCode();

    /**
     * 获取错误描述
     * @return
     */
    String getMessage();

}
