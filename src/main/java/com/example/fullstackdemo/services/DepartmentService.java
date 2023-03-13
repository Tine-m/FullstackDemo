package com.example.fullstackdemo.services;

import com.example.fullstackdemo.dto.DeptCountEmpDTO;
import com.example.fullstackdemo.model.Department;
import com.example.fullstackdemo.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

  DepartmentRepository departmentRepository;

  public DepartmentService(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  public Department findByDeptno(int deptNo) {
    return departmentRepository.findByDeptno(deptNo);
  }

  public List<DeptCountEmpDTO> countEmployees() {
    return departmentRepository.countEmployees();
  }
}
