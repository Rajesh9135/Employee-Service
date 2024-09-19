package com.spring.exception;

import org.springframework.http.HttpStatus;

public enum HttpStatusCode {

	/*******************************
	 * 1xx Informational
	 *******************************/

	CONTINUE(100, HttpStatus.CONTINUE), SWITCHING_PROTOCOLS(101, HttpStatus.SWITCHING_PROTOCOLS),
	PROCESSING(102, HttpStatus.PROCESSING),

	/********************************
	 * 2xx Success
	 ********************************/

	OK(200, HttpStatus.OK), CREATED(201, HttpStatus.CREATED), ACCEPTED(202, HttpStatus.ACCEPTED),
	NON_AUTHORITATIVE_INFORMATION(203, HttpStatus.NON_AUTHORITATIVE_INFORMATION),
	NO_CONTENT(204, HttpStatus.NO_CONTENT), RESET_CONTENT(205, HttpStatus.RESET_CONTENT),
	PARTIAL_CONTENT(206, HttpStatus.PARTIAL_CONTENT), MULTI_STATUS(207, HttpStatus.MULTI_STATUS),
	ALREADY_REPORTED(208, HttpStatus.ALREADY_REPORTED), IM_USED(226, HttpStatus.IM_USED),

	/*********************************
	 * 3xx Redirection
	 *********************************/

	MULTIPLE_CHOICES(300, HttpStatus.MULTIPLE_CHOICES), MOVED_PERMANENTLY(301, HttpStatus.MOVED_PERMANENTLY),
	FOUND(302, HttpStatus.FOUND), SEE_OTHER(303, HttpStatus.SEE_OTHER), NOT_MODIFIED(304, HttpStatus.NOT_MODIFIED),
	USE_PROXY(305, HttpStatus.USE_PROXY), TEMPORARY_REDIRECT(307, HttpStatus.TEMPORARY_REDIRECT),
	PERMANENT_REDIRECT(308, HttpStatus.PERMANENT_REDIRECT),

	/***********************************
	 * 4xx Client Errors
	 ***********************************/

	BAD_REQUEST(400, HttpStatus.BAD_REQUEST), UNAUTHORIZED(401, HttpStatus.UNAUTHORIZED),
	PAYMENT_REQUIRED(402, HttpStatus.PAYMENT_REQUIRED), FORBIDDEN(403, HttpStatus.FORBIDDEN),
	NOT_FOUND(404, HttpStatus.NOT_FOUND), METHOD_NOT_ALLOWED(405, HttpStatus.METHOD_NOT_ALLOWED),
	NOT_ACCEPTABLE(406, HttpStatus.NOT_ACCEPTABLE),
	PROXY_AUTHENTICATION_REQUIRED(407, HttpStatus.PROXY_AUTHENTICATION_REQUIRED),
	REQUEST_TIMEOUT(408, HttpStatus.REQUEST_TIMEOUT), CONFLICT(409, HttpStatus.CONFLICT), GONE(410, HttpStatus.GONE),
	LENGTH_REQUIRED(411, HttpStatus.LENGTH_REQUIRED), PRECONDITION_FAILED(412, HttpStatus.PRECONDITION_FAILED),
	PAYLOAD_TOO_LARGE(413, HttpStatus.PAYLOAD_TOO_LARGE), URI_TOO_LONG(414, HttpStatus.URI_TOO_LONG),
	UNSUPPORTED_MEDIA_TYPE(415, HttpStatus.UNSUPPORTED_MEDIA_TYPE),
	EXPECTATION_FAILED(417, HttpStatus.EXPECTATION_FAILED), I_AM_A_TEAPOT(418, HttpStatus.I_AM_A_TEAPOT),
	UNPROCESSABLE_ENTITY(422, HttpStatus.UNPROCESSABLE_ENTITY), LOCKED(423, HttpStatus.LOCKED),
	FAILED_DEPENDENCY(424, HttpStatus.FAILED_DEPENDENCY), TOO_EARLY(425, HttpStatus.TOO_EARLY),
	UPGRADE_REQUIRED(426, HttpStatus.UPGRADE_REQUIRED), PRECONDITION_REQUIRED(428, HttpStatus.PRECONDITION_REQUIRED),
	TOO_MANY_REQUESTS(429, HttpStatus.TOO_MANY_REQUESTS),
	REQUEST_HEADER_FIELDS_TOO_LARGE(431, HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE),
	UNAVAILABLE_FOR_LEGAL_REASONS(451, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS),

	/******************************************
	 * 5xx Server Errors
	 ******************************************/
	INTERNAL_SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR), NOT_IMPLEMENTED(501, HttpStatus.NOT_IMPLEMENTED),
	BAD_GATEWAY(502, HttpStatus.BAD_GATEWAY), SERVICE_UNAVAILABLE(503, HttpStatus.SERVICE_UNAVAILABLE),
	GATEWAY_TIMEOUT(504, HttpStatus.GATEWAY_TIMEOUT),
	HTTP_VERSION_NOT_SUPPORTED(505, HttpStatus.HTTP_VERSION_NOT_SUPPORTED),
	VARIANT_ALSO_NEGOTIATES(506, HttpStatus.VARIANT_ALSO_NEGOTIATES),
	INSUFFICIENT_STORAGE(507, HttpStatus.INSUFFICIENT_STORAGE), LOOP_DETECTED(508, HttpStatus.LOOP_DETECTED),
	NOT_EXTENDED(510, HttpStatus.NOT_EXTENDED),
	NETWORK_AUTHENTICATION_REQUIRED(511, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);

	private final int code;
	private final HttpStatus httpStatus;

	HttpStatusCode(int code, HttpStatus httpStatus) {
		this.code = code;
		this.httpStatus = httpStatus;
	}

	public int getCode() {
		return code;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public static HttpStatus getHttpStatusByCode(int code) {
		for (HttpStatusCode errorCode : values()) {
			if (errorCode.getCode() == code) {
				return errorCode.getHttpStatus();
			}
		}
		return HttpStatus.INTERNAL_SERVER_ERROR; // Default status if no match
	}
}
