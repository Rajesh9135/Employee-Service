package com.spring.entity;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "employee")
@Data
@Accessors(chain = true)
@JsonInclude(Include.NON_NULL)
public class Employee {

	@Id
	@Column(name = "emp_id")
	private String employeeId;

	@Column(name = "emp_name")
	@NotBlank(message = "Employee Name cannot be blank")	
	private String employeeName;

	@Column(name = "emp_email")
	@Email(message = "Invalid email format")
	@NotBlank(message = "Employee Email cannot be blank")
	private String employeeEmail;

	@Column(name = "emp_phone")
	@NotBlank(message = "Employee Phone cannot be blank")
	private String employeePhone;

	@Column(name = "emp_address")
	@Size(max = 255, message = "Employee Address must be less than or equal to 255 characters")
	@NotBlank(message = "Address cannot be blank")
	private String employeeAddress;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "employee")
	@Fetch(FetchMode.SUBSELECT)
	private List<SalaryModel> salary;
}
