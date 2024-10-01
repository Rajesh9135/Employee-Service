package com.spring.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.constant.AppConstant;
import com.spring.entity.Employee;
import com.spring.entity.repository.EmployeeRepository;
import com.spring.exception.AppException;
import com.spring.request.Request;
import com.spring.response.Response;
import com.spring.response.ResponseWrapper;
import com.spring.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseWrapper saveEmployee(Request request) {
		log.info("[ Create a employee ] [Request Body : " + request.toString() + "]");
		ResponseWrapper responseWrapper = new ResponseWrapper();
		request.getEmployee().setEmployeeId(UUID.randomUUID().toString());
		
		Employee employee = request.getEmployee();
		
		if (employee.getSalary() != null && !employee.getSalary().isEmpty())
			employee.getSalary().forEach(salary -> {
				salary.setId(UUID.randomUUID().toString());
				salary.setEmployee(employee);
			});
		try {
			responseWrapper.setEmployee(employeeRepository.save(employee));
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(AppConstant.INTERNAL_SERVER_ERROR, AppConstant.ERROR);
		}
		Response response = new Response(AppConstant.CREATED, AppConstant.SUCCESS);
		responseWrapper.setResponse(response);
		return responseWrapper;
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseWrapper getAllEmployee() {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		log.info("[ Get all employee ]");
		try {
			List<Employee> employees = employeeRepository.findAll();
			if (employees.isEmpty())
				throw new AppException(AppConstant.NOT_FOUND, "Employee not found ");
			responseWrapper.setEmployees(employees);
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(AppConstant.INTERNAL_SERVER_ERROR, AppConstant.ERROR);
		}
		Response response = new Response(AppConstant.OK, AppConstant.SUCCESS);
		responseWrapper.setResponse(response);
		return responseWrapper;
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseWrapper getEmployeeByEmployeeId(String employee) {
		if (employee == null || "".equalsIgnoreCase(employee))
			throw new AppException(AppConstant.BAD_REQUEST, "Employee id cannot be blank");

		ResponseWrapper responseWrapper = new ResponseWrapper();
		log.info("[ Get employee by employeeid ] [employeeid : " + employee + "]");
		try {
			Employee emp = employeeRepository.findById(employee).orElseThrow(
					() -> new AppException(AppConstant.NOT_FOUND, AppConstant.EMP_NOT_FOUND_WITH_ID + employee));
			responseWrapper.setEmployee(emp);
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(AppConstant.INTERNAL_SERVER_ERROR, AppConstant.ERROR);
		}
		Response response = new Response(AppConstant.OK, AppConstant.SUCCESS);
		responseWrapper.setResponse(response);
		return responseWrapper;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseWrapper deleteEmployee(String employeeId) {
		if (employeeId == null || "".equalsIgnoreCase(employeeId))
			throw new AppException(AppConstant.BAD_REQUEST, "Employee id cannot be blank");
		ResponseWrapper responseWrapper = new ResponseWrapper();
		log.info("[ Delete employee by employeeid ] [employeeid : " + employeeId + "]");
		try {
			Employee emp = employeeRepository.findById(employeeId).orElseThrow(
					() -> new AppException(AppConstant.NOT_FOUND, "Employee not found with ID: " + employeeId));
			employeeRepository.deleteById(employeeId);
			responseWrapper.setEmployee(emp);
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(AppConstant.INTERNAL_SERVER_ERROR, AppConstant.ERROR);
		}
		Response response = new Response(AppConstant.OK, AppConstant.SUCCESS);
		responseWrapper.setResponse(response);
		return responseWrapper;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseWrapper updateEmployee(Request request) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		log.info("[ Update a employee ] [Request Body : " + request.toString() + "]");
		try {
			Employee emp = employeeRepository.findById(request.getEmployee().getEmployeeId())
					.orElseThrow(() -> new AppException(AppConstant.NOT_FOUND,
							"Employee not found with ID: " + request.getEmployee().getEmployeeId()));
			emp.setEmployeeAddress(request.getEmployee().getEmployeeAddress())
					.setEmployeeEmail(request.getEmployee().getEmployeeEmail())
					.setEmployeeName(request.getEmployee().getEmployeeName())
					.setEmployeePhone(request.getEmployee().getEmployeePhone())
					.setSalary(request.getEmployee().getSalary());
			responseWrapper.setEmployee(employeeRepository.save(request.getEmployee()));
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(AppConstant.INTERNAL_SERVER_ERROR, AppConstant.ERROR);
		}
		Response response = new Response(AppConstant.OK, AppConstant.SUCCESS);
		responseWrapper.setResponse(response);
		return responseWrapper;
	}

}
