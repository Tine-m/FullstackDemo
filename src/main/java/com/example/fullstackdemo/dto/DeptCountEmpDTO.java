package com.example.fullstackdemo.dto;

public class DeptCountEmpDTO {
  private int deptNo;
  private String dname;
  private int numberOfEmployees;

  public DeptCountEmpDTO(int deptNo, String dname, int numberOfEmployees) {
    this.deptNo = deptNo;
    this.dname = dname;
    this.numberOfEmployees = numberOfEmployees;
  }

  public DeptCountEmpDTO() {
  }

  public String getDname() {
    return dname;
  }

  public void setDname(String dname) {
    this.dname = dname;
  }

  public int getNumberOfEmployees() {
    return numberOfEmployees;
  }

  public void setNumberOfEmployees(int numberOfEmployees) {
    this.numberOfEmployees = numberOfEmployees;
  }

  public int getDeptNo() {
    return deptNo;
  }

  public void setDeptNo(int deptNo) {
    this.deptNo = deptNo;
  }
}
