package com.example.fullstackdemo.repositories;

import com.example.fullstackdemo.model.Department;
import com.example.fullstackdemo.model.Employee;
import com.example.fullstackdemo.repositories.util.DBManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository()
public class EmployeeRepository {

  private DepartmentRepository departmentRepository = new DepartmentRepository();

  public EmployeeRepository() {  }

  public Employee findByEmpNo(int empNo) {
    try {
      Connection con = DBManager.getConnection();
      String SQL = "select * from emp where empno = ?";
      PreparedStatement pstmt = con.prepareStatement(SQL);
      pstmt.setInt(1, empNo);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return new Employee(
            rs.getInt("empno"),
            rs.getString("ename"),
            rs.getString("job"),
            rs.getDate("hiredate").toLocalDate(),
            rs.getInt("sal"), null);
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return null;
  }

  public List<Employee> findAll() {
    List<Employee> employees = new ArrayList<>();
    try {
      Connection connection = DBManager.getConnection();
      Statement statement = connection.createStatement();
      String sql = "select * from emp";
      ResultSet rs = statement.executeQuery(sql);

      int empNo;
      String eName;
      String job;
      LocalDate hireDate;
      int sal;
      Employee emp;

      while (rs.next()) {
        empNo = rs.getInt("empno");
        eName = rs.getString("ename");
        job = rs.getString("job");
        hireDate = rs.getDate("hiredate").toLocalDate();
        sal = rs.getInt("sal");
        emp = new Employee(empNo, eName, job, hireDate, sal);
        employees.add(emp);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return employees;
  }

  public List<Employee> findAllWithDeptInfo() {
    List<Employee> employees = new ArrayList<>();
    try {
      Connection connection = DBManager.getConnection();
      Statement statement = connection.createStatement();
      String sql = "SELECT * FROM emp NATURAL JOIN dept";
      ResultSet rs = statement.executeQuery(sql);

      int empNo;
      String eName;
      String job;
      LocalDate hireDate;
      int sal;
      Employee emp;
      Department dept;

      while (rs.next()) {
        empNo = rs.getInt("empno");
        eName = rs.getString("ename");
        job = rs.getString("job");
        hireDate = rs.getDate("hiredate").toLocalDate();
        sal = rs.getInt("sal");
        dept = departmentRepository.load(rs);
        emp = new Employee(empNo, eName, job, hireDate, sal, dept);
        employees.add(emp);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return employees;
  }

}
