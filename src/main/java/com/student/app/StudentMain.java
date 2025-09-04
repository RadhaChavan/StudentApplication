package com.student.app;

import java.util.Scanner;

import com.student.model.Student;
import com.student.service.StudentService;

public class StudentMain {

	public static void main(String[] args) {
		StudentService service=new StudentService();
		
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			System.out.println("1.Add Student");
			System.out.println("2.View Student");
			System.out.println("3.Update Student");
			System.out.println("4.Delete Student");
			System.out.println("Enter Your Choice");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:{
				Student student=new Student();
				System.out.println("Register New Student.");
				System.out.println("Enter Student First Name");
				student.setFname(scanner.next());
				System.out.println("Enter Student Last Name");
				student.setLname(scanner.next());
				System.out.println("Enter Student  class");
				student.setSyear(scanner.nextLine());
				scanner.nextLine();
				System.out.println("Enter Student Department");
				student.setDepartment(scanner.next());
				System.out.println("Enter Student Marks");
				student.setMarks(scanner.nextDouble());
			
				service.addStudent(student);
				break;
			}
			case 2:{
				System.out.println("Student Record.");
				service.viewStudent();
				break;
			}
			case 3:{
				Student student=new Student();
				System.out.println("Ensert data to update Student Record.");
				System.out.println("Enter Student First Name");
				student.setFname(scanner.next());
				System.out.println("Enter Student Last Name");
				student.setLname(scanner.next());
				System.out.println("Enter Student  class");
				student.setSyear(scanner.nextLine());
				scanner.nextLine();
				System.out.println("Enter Student Department");
				student.setDepartment(scanner.next());
				System.out.println("Enter Student Marks");
				student.setMarks(scanner.nextDouble());
				System.out.println("ENter Rollno to update");
				int rollno=scanner.nextInt();
				service.updateStudent(rollno);
				break;
			}
			
			}
			
		}

	}

}
