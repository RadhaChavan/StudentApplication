package com.student.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.student.dbconnection.DbConnection;
import com.student.model.Student;

public class StudentService {

    // Add Student
    public void addStudent(Student student) {
        String query = "INSERT INTO student (FirstName, LastName, StudentYear, Department, Marks) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, student.getFname());
            ps.setString(2, student.getLname());
            ps.setString(3, student.getSyear());
            ps.setString(4, student.getDepartment());
            ps.setDouble(5, student.getMarks());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println(" Student Added Successfully..");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View Students
    public void viewStudents() {
        String query = "SELECT * FROM student";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("+--------+-----------+----------+-------------+------------+-------+");
            System.out.println("| Rollno | FirstName | LastName | StudentYear | Department | Marks |");
            System.out.println("+--------+-----------+----------+-------------+------------+-------+");

            while (rs.next()) {
                System.out.printf("| %-6d | %-9s | %-8s | %-11s | %-10s | %-5.1f |\n",
                        rs.getInt("Rollno"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("StudentYear"),
                        rs.getString("Department"),
                        rs.getDouble("Marks"));
            }

            System.out.println("+--------+-----------+----------+-------------+------------+-------+");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Student
    public void updateStudent(int rollno, Student student) {
        String query = "UPDATE student SET FirstName=?, LastName=?, StudentYear=?, Department=?, Marks=? WHERE Rollno=?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, student.getFname());
            ps.setString(2, student.getLname());
            ps.setString(3, student.getSyear());
            ps.setString(4, student.getDepartment());
            ps.setDouble(5, student.getMarks());
            ps.setInt(6, rollno);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println(" Student Updated Successfully..");
            } else {
                System.out.println(" Student not found with Rollno: " + rollno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent(int rollno) {
        String query = "DELETE FROM student WHERE Rollno=?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, rollno);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println(" Student Deleted Successfully..");
            } else {
                System.out.println(" Student not found with Rollno: " + rollno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
