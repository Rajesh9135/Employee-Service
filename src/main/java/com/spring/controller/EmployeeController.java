package com.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.request.Request;
import com.spring.response.ResponseWrapper;
import com.spring.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(value = "*")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;
	
	@PostMapping(value = "v1/save")
	public ResponseEntity<ResponseWrapper> saveEmployee(@RequestBody Request request){
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(request));
	}
	
	@GetMapping(value = "v1/get-all-employee")
	public ResponseEntity<ResponseWrapper> getAllEmployee(){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployee());
	}
	
	@GetMapping(value = "v1/get-employee/by/{employeeId}")
	public ResponseEntity<ResponseWrapper> findEmployeeById(@PathVariable(value = "employeeId") String employeeId){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeByEmployeeId(employeeId));
	}
	
	@DeleteMapping(value = "v1/delete-employee/by/{employeeId}")
	public ResponseEntity<ResponseWrapper> deletedEmployeeById(@PathVariable(value = "employeeId") String employeeId){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.deleteEmployee(employeeId));
	}
	
	@PutMapping(value = "v1/update-employee")
	public ResponseEntity<ResponseWrapper> updateEmployeeById(@RequestBody Request request){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(request));
	}
	
	
}
