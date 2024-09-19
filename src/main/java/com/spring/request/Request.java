package com.spring.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.spring.entity.Employee;

import lombok.Data;
import lombok.experimental.Accessors;

@JsonInclude(Include.NON_NULL)
@Data	
@Accessors(chain = true)
public class Request {
	private Employee employee;
}
