package com.admin.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lisheng
 * @version ServiceException, v0.1 2018/11/30 15:12
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 8935197089745865786L;

    private ErrorCode errorCode;

    public ServiceException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 将CheckedException转换为UncheckedException.
     */
    public static RuntimeException unchecked(Throwable ex) {
        if (ex instanceof RuntimeException) {
            return (RuntimeException) ex;
        } else {
            return new RuntimeException(ex);
        }
    }
}