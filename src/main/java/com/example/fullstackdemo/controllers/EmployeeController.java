package com.example.fullstackdemo.controllers;

import com.example.fullstackdemo.model.Employee;
import com.example.fullstackdemo.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("emp")
public class EmployeeController {

  EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("")
  public ResponseEntity<Employee> one(@RequestParam  int empno) {
    Employee emp = employeeService.findByEmpNo(empno);
    return new ResponseEntity<>(emp, HttpStatus.OK);
  }

  @GetMapping("all")
  public ResponseEntity<List<Employee>> findAll() {
    List<Employee> resultList = employeeService.findAll();
    return new ResponseEntity<>(resultList, HttpStatus.OK);
  }

  @GetMapping("alldept")
  public ResponseEntity<List<Employee>> findAllWithDeptInfo() {
    List<Employee> resultList = employeeService.findAllWithDeptInfo();
    return new ResponseEntity<>(resultList, HttpStatus.OK);
  }

}
