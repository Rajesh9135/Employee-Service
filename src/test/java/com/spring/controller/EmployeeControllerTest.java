package com.spring.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.spring.constant.AppConstant;
import com.spring.entity.Employee;
import com.spring.exception.AppException;
import com.spring.response.Response;
import com.spring.response.ResponseWrapper;
import com.spring.service.EmployeeService;

@SpringBootTest
@SpringJUnitConfig
public class EmployeeControllerTest {

	@InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @Test
    public void testGetAllEmployee_Success() {
        // Arrange
        Employee employee = new Employee(); // Initialize as needed
        List<Employee> employees = Collections.singletonList(employee);
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setEmployees(employees);
        responseWrapper.setResponse(new Response(AppConstant.OK, AppConstant.SUCCESS));

        when(employeeService.getAllEmployee()).thenReturn(responseWrapper);

        // Act
        ResponseEntity<ResponseWrapper> responseEntity = employeeController.getAllEmployee();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseWrapper, responseEntity.getBody());
    }

//    @Test
//    public void testGetAllEmployee_EmptyList() {
//        // Arrange
//        ResponseWrapper responseWrapper = new ResponseWrapper();
//        responseWrapper.setResponse(new Response(AppConstant.NOT_FOUND, "Employee not found"));
//
//        when(employeeService.getAllEmployee()).thenThrow(new AppException(AppConstant.NOT_FOUND, "Employee not found"));
//
//        // Act
//        ResponseEntity<ResponseWrapper> responseEntity = employeeController.getAllEmployee();
//
//        // Assert
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertEquals(responseWrapper.getResponse().getStatusMessage(), "Employee not found");
//    }
//
//    @Test
//    public void testGetAllEmployee_InternalServerError() {
//        // Arrange
//        when(employeeService.getAllEmployee()).thenThrow(new RuntimeException("Internal Server Error"));
//
//        // Act
//        ResponseEntity<ResponseWrapper> responseEntity = employeeController.getAllEmployee();
//
//        // Assert
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
//        assertEquals(AppConstant.ERROR, responseEntity.getBody().getResponse().getStatusMessage());
//    }
}
