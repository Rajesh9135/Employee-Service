package com.spring.service;

import com.spring.request.Request;
import com.spring.response.ResponseWrapper;

public interface EmployeeService {

	public ResponseWrapper saveEmployee(Request request);
	
	public ResponseWrapper getAllEmployee();
	
	public ResponseWrapper getEmployeeByEmployeeId(String employee);
	
	public ResponseWrapper deleteEmployee(String employeeId);
	
	public ResponseWrapper updateEmployee(Request request);
}
