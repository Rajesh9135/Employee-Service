package com.spring.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@RequiredArgsConstructor
public class AppException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5791348524589307723L;
	
	private Integer statusCode;
	private String statusMessage;
	
	public AppException(Integer statusCode, String statusMessage) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	public AppException(Integer statusCode,Throwable cause) {
		super(statusCode.toString(),cause);
		// TODO Auto-generated constructor stub
	}


	
	

}
