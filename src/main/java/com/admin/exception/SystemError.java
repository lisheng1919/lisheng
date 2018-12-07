package com.admin.exception;

/**
 * @author lisheng
 * @version SystemError, v0.1 2018/8/30 14:04
 * 通用错误集合
 */
public enum SystemError implements ErrorCode {
	UNKNOWN_ERROR("999999", "未知错误"),
	SYSTEM_ERROR("999998","系统异常"),
	FAST_VISIT_ERROR("999997","服务繁忙，请稍后再试!"),
	COMMON_PARAMETER_MERGE("999996", "复制数据操作错误"),
	CONNECTION_TIME_OUT("999995", "服务器连接超时"),
	SERVER_CONNECTION_ERROR("999994", "服务器请求错误"),
	COMMON_DATE_TRANSFER("999993", "时间格式转换错误"),
	COMMON_PARAMTER_ERROR("999992", "请求参数缺失或者错误"),
	COMMON_UNKNOWN_ERROR("999991", "其他错误"),
	;

	private String errorCode;
	private String message;

	SystemError(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	@Override
	public String getCode() {
		return errorCode;
	}

	@Override
	public String getMessage() {
		return message;
	}

    @Override
    public String toString() {
        return "SystemError{" +
                "errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
