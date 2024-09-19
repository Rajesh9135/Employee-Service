package com.spring.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, String>{

}
