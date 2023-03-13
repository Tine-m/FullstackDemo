package com.example.fullstackdemo.controllers;

import com.example.fullstackdemo.dto.DeptCountEmpDTO;
import com.example.fullstackdemo.model.Department;
import com.example.fullstackdemo.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("dept")
public class DepartmentController {

  DepartmentService departmentService;

  public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @GetMapping("")
  public ResponseEntity<Department> findDepartment(@RequestParam int deptno) {
    Department dept = departmentService.findByDeptno(deptno);
    return new ResponseEntity<>(dept, HttpStatus.OK);
  }

  @GetMapping("count")
  public ResponseEntity<List<DeptCountEmpDTO>> count() {
    List<DeptCountEmpDTO> resultList = departmentService.countEmployees();
    return new ResponseEntity<>(resultList, HttpStatus.OK);
  }
}
