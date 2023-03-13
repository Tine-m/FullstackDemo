package com.example.fullstackdemo.controllers;

import com.example.fullstackdemo.dto.DeptCountEmpDTO;
import com.example.fullstackdemo.model.Department;
import com.example.fullstackdemo.services.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

  DepartmentService departmentService;

  public ThymeleafController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @GetMapping("")
  public String findDepartment(@RequestParam int deptno, Model model) {
    Department dept = departmentService.findByDeptno(deptno);
    model.addAttribute("result", dept);
    return "departmentDetails";
  }

  @GetMapping("count")
  public String count(Model model) {
    List<DeptCountEmpDTO> resultList = departmentService.countEmployees();
    model.addAttribute("dtoResult", resultList);
    return "departmentCount";
  }
}
