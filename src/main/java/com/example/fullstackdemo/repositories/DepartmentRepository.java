package com.example.fullstackdemo.repositories;

import com.example.fullstackdemo.dto.DeptCountEmpDTO;
import com.example.fullstackdemo.model.Department;
import com.example.fullstackdemo.repositories.util.DBManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

  public Department findByDeptno(int deptNo) {
    try {
      Connection con = DBManager.getConnection();
      String SQL = "SELECT * FROM dept WHERE deptno = ?";
      PreparedStatement pstmt = con.prepareStatement(SQL);
      pstmt.setInt(1, deptNo);
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        int deptno = rs.getInt("deptno");
        String dname = rs.getString("dname");
        String loc = rs.getString("loc");
        return new Department(deptno, dname, loc);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<DeptCountEmpDTO> countEmployees() {
    List<DeptCountEmpDTO> resultList = new ArrayList<>();
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "select deptno, dname, count(*) as count_emp " +
          "from dept join emp using (deptno) group by deptno";
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery(SQL);
      while (rs.next()) {
        int deptno = rs.getInt("deptno");
        String dname = rs.getString("dname");
        int count_emp = rs.getInt("count_emp");
        resultList.add(new DeptCountEmpDTO(deptno, dname, count_emp));
      }
      return resultList;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Department load(ResultSet rs) throws SQLException {
    int deptno = rs.getInt("deptno");
    String dname = rs.getString("dname");
    String loc = rs.getString("loc");
    return new Department(deptno, dname, loc);
  }
}
