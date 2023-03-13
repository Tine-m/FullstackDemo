package com.example.fullstackdemo.model;

import java.time.LocalDate;

public class Employee {

  private int empno;
  private String eName;
  private String job;
  private LocalDate hireDate;
  private int sal;
  private Department dept;

  public Employee() {
  }

  public Employee(int empno, String eName, String job, LocalDate hireDate, int sal, Department dept) {
    this.empno = empno;
    this.eName = eName;
    this.job = job;
    this.hireDate = hireDate;
    this.sal = sal;
    this.dept = dept;
  }

  public Employee(int empno, String eName, String job, LocalDate hireDate, int sal) {
    this(empno, eName, job, hireDate, sal, null);
  }

  public int getEmpno() {
    return empno;
  }

  public String geteName() {
    return eName;
  }

  public String getJob() {
    return job;
  }

  public LocalDate getHireDate() {
    return hireDate;
  }

  public int getSal() {
    return sal;
  }

  public Department getDept() {
    return dept;
  }
}
