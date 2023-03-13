package com.example.fullstackdemo.services;

import com.example.fullstackdemo.model.Employee;
import com.example.fullstackdemo.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

  EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public Employee findByEmpNo(int empNo) {
    return employeeRepository.findByEmpNo(empNo);
  }

  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  public List<Employee> findAllWithDeptInfo() {
    return employeeRepository.findAllWithDeptInfo();
  }
}
