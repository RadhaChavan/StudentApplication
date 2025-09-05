package com.student.app;

import java.util.Scanner;

import com.student.model.Student;
import com.student.service.StudentService;

public class StudentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Student First Name:");
                    String fname = sc.next();
                    System.out.println("Enter Student Last Name:");
                    String lname = sc.next();
                    System.out.println("Enter Student Year:");
                    String syear = sc.next();
                    System.out.println("Enter Student Department:");
                    String dept = sc.next();
                    System.out.println("Enter Student Marks:");
                    double marks = sc.nextDouble();

                    Student s = new Student(0, fname, lname, syear, dept, marks);
                    service.addStudent(s);
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Rollno to Update: ");
                    int upRoll = sc.nextInt();
                    System.out.println("Enter New First Name:");
                    String ufname = sc.next();
                    System.out.println("Enter New Last Name:");
                    String ulname = sc.next();
                    System.out.println("Enter New Year:");
                    String usyear = sc.next();
                    System.out.println("Enter New Department:");
                    String udept = sc.next();
                    System.out.println("Enter New Marks:");
                    double umarks = sc.nextDouble();

                    Student updated = new Student(upRoll, ufname, ulname, usyear, udept, umarks);
                    service.updateStudent(upRoll, updated);
                    break;

                case 4:
                    System.out.print("Enter Rollno to Delete: ");
                    int delRoll = sc.nextInt();
                    service.deleteStudent(delRoll);
                    break;

                case 5:
                    System.out.println(" Exiting...!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid Choice, Try Again!");
            }
        }
    }
}
