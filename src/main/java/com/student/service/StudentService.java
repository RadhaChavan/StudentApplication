package com.student.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.student.dbconnection.DbConnection;
import com.student.model.Student;

public class StudentService {
	public void addStudent(Student student) {
		String query="insert into student(FirstName,LastName,StudentYear,Department,Marks) values(?,?,?,?,?)";
		try{
			Connection con=DbConnection.getConnection();
			PreparedStatement prepareStatement=con.prepareStatement(query);
			prepareStatement.setString(1,student.getFname());
			prepareStatement.setString(2,student.getLname());
			prepareStatement.setString(3,student.getSyear());
			prepareStatement.setString(4,student.getDepartment());
			prepareStatement.setDouble(5,student.getMarks());
			prepareStatement.executeUpdate();
			System.out.println("Student Added Successfully..");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateStudent(int rollno) {
		String query="update student set FirstName=?,LastName=?,StudentYear=?,Department=?,Marks=? where Rollno=?";
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement prepareStatement=con.prepareStatement(query);
			Student student=new Student();
			prepareStatement.setString(1,student.getFname());
			prepareStatement.setString(2,student.getLname());
			prepareStatement.setString(3,student.getSyear());
			prepareStatement.setString(4,student.getDepartment());
			prepareStatement.setDouble(5,student.getMarks());
			prepareStatement.setInt(6, student.getRollno());
			prepareStatement.executeUpdate();
			System.out.println("Student updated Succcessfully..");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void viewStudent() {
		String query="select * from student";
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement prepareStatement=con.prepareStatement(query);
			ResultSet resultset=prepareStatement.executeQuery();
			System.out.println("+--------+-----------+----------+-------------+------------+-------+");
			System.out.println("| Rollno | FirstName | LastName | StudentYear | Department | Marks |");
			System.out.println("+--------+-----------+----------+-------------+------------+-------+");

			while (resultset.next()) {   // ✅ Loop through all rows
			    System.out.printf("| %-6d | %-9s | %-8s | %-11s | %-10s | %-5.1f |\n",
			    		resultset.getInt("Rollno"),
			    		resultset.getString("FirstName"),
			    		resultset.getString("LastName"),
			    		resultset.getString("StudentYear"),
			    		resultset.getString("Department"),
			    		resultset.getDouble("Marks"));
			}
			System.out.println("+--------+-----------+----------+-------------+------------+-------+");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
