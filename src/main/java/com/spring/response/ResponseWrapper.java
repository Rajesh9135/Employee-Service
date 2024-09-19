package com.spring.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.spring.entity.Employee;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class ResponseWrapper {

	private Response response;
	private Employee employee;
	private List<Employee> employees;
	
}
