package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "salary")
@Data
@Accessors(chain = true)
public class SalaryModel {

	@Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "salary")
    @NotNull(message = "Salary cannot be null")
    private Double salary;
    
    @Column(name = "bonuce")
    @NotNull(message = "Bonuce cannot be null")
    private Double bonuce;
    
    @Column(name = "leave_inhancment")
    @NotNull(message = "Leave Inhancment cannot be null")
    private Double leaveInhancment;
    
    @Column(name = "diwali_bakshis")
    @NotNull(message = "Diwali Bakshis cannot be null")
    private Double diwaliBakshis;
    
    @Column(name = "increement")
    @NotNull(message = "Increement cannot be null")
    private Double increement;
    
    @Column(name = "increement_year")
    @NotNull(message = "Year cannot be null")
    private Integer year;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    @JsonIgnore
    private Employee employee;
}
