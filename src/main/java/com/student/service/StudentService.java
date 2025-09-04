package com.student.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.student.dbconnection.DbConnection;

public class StudentService {
	
	public void addStudent() {
		//String query="insert into student values(?,?,?,?,?,?)";
		String query="select * from student";
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement prepareStatement=con.prepareStatement(query);
			ResultSet resultset=prepareStatement.executeQuery();
			if(resultset.next()) {
				System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getString(3)+" "
			+resultset.getString(4)+" "+resultset.getString(5)+" "+resultset.getString(6));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
