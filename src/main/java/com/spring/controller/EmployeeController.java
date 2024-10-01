package com.spring.controller;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(value = "*")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;
	
	@Tag(name="Post",description = "Post method for create a new employee")
	@Operation(summary = "Create a new employee",description = "Create a new employee as par api request body")
	@PostMapping(value = "v1/save")
	public ResponseEntity<ResponseWrapper> saveEmployee(@RequestBody Request request){
		return ResponseEntity.ok(employeeService.saveEmployee(request));
	}
	
	@Tag(name="Get",description = "Get method for get employee details")
	@Operation(summary = "Get Employee",description = "Get all list of employee to presetn in database")
	@GetMapping(value = "v1/get-all-employee")
	public ResponseEntity<ResponseWrapper> getAllEmployee(){
		return ResponseEntity.ok(employeeService.getAllEmployee());
	}
	
	@Tag(name="Get",description = "Get method for get employee details")
	@Operation(summary = "Get Employee",description = "Get a single employee on the basis of employee id")
	@GetMapping(value = "v1/get-employee/by/{employeeId}")
	public ResponseEntity<ResponseWrapper> findEmployeeById(@PathVariable(value = "employeeId") String employeeId){
		return ResponseEntity.ok(employeeService.getEmployeeByEmployeeId(employeeId));
	}
	
	@Tag(name="Delete",description = "Delete method for delete employee")
	@Operation(summary = "Delete Employee",description = "Delete a particular employee on the basis of employeeid")
	@DeleteMapping(value = "v1/delete-employee/by/{employeeId}")
	public ResponseEntity<ResponseWrapper> deletedEmployeeById(@PathVariable(value = "employeeId") String employeeId){
		return ResponseEntity.ok(employeeService.deleteEmployee(employeeId));
	}
	
	@Tag(name="Put",description = "put method for update employee details")
	@Operation(summary = "Update Employee",description = "Update a single employee on as per request body")
	@PutMapping(value = "v1/update-employee")
	public ResponseEntity<ResponseWrapper> updateEmployeeById(@RequestBody Request request){
		return ResponseEntity.ok(employeeService.updateEmployee(request));
	}
	
	
}
