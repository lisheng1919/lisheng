package com.admin.exception;


import lombok.Data;

/**
 * @author lisheng
 * @version ReturnMessageException, v0.1 2018/1/21 22:22
 */
@Data
public class ReturnMessageException extends RuntimeException {
	private String code;
	private String msg;
	public ReturnMessageException(String code,String msg ) {
		this.msg = msg;
		this.code = code;
	}



}
