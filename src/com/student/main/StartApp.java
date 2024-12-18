package com.student.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.student.dao.Dao;
import com.student.manage.Student;

public class StartApp {

    public static void main(String[] args) {
        System.out.println("Welcome Gentlemen");
        System.out.println();
        
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                Menu();
                
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        addStudent(sc);
                        break;
                    case 2:
                        deleteStudent(sc);
                        break;
                    case 3:
                        viewAllStudents();
                        break;
                    case 4:
                        updateStudentData(sc);
                        break;
                    case 5:
                    	System.out.println("Thanks byee.. byeee...");
                    	System.out.println("Visit again");
                        return;
                    default:
                        System.err.println("Invalid choice. Please select a valid option.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter numbers only.");
                sc.nextLine();
            }
        }
    }

    private static void Menu() {
  
        System.out.println("\nPress 1 to add student");
        System.out.println("Press 2 to delete student");
        System.out.println("Press 3 to view all students");
        System.out.println("Press 4 to update student data");
        System.out.println("Press 5 to exit");
    }

    private static void addStudent(Scanner sc) {
        try {
        	String re = "[a-zA-Z]+";
        	String ph = "[0-9]{10}";
            System.out.println("Enter user Name:");
            String name = sc.next();
            System.out.println("Enter user Phone:");
            String phone = sc.next();
            System.out.println("Enter user City:");
            String city = sc.next(); 
            
            Pattern pattern = Pattern.compile(re);
        	Matcher matcher = pattern.matcher(name);
        	boolean matches = matcher.matches();
        	
        	Pattern pattern2 = Pattern.compile(ph);
        	Matcher matcher2 = pattern2.matcher(phone);
        	boolean matches2 = matcher2.matches();
           

            if (matches && matches2) {
            	Student student = new Student(name, phone, city);
                Dao.insertStud(student);
                System.out.println("Student added successfully!");
			}else {
				System.out.println("enter charachters only in name\nand 10 digit number in phone");
			}
           
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter correct data.");
            sc.nextLine();
        }
    }

    private static void deleteStudent(Scanner sc) {
        try {
            System.out.println("Enter student ID to delete the student data:");
            int sId = sc.nextInt();
            Dao.deleteStud(sId);

            System.out.println("Student with ID " + sId + " deleted successfully.");
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a valid student ID.");
            sc.nextLine();
        }
    }

    private static void viewAllStudents() {
        Dao.ShowAllStudents();
    }

    private static void updateStudentData(Scanner sc) {
        try {
            System.out.println("Enter student ID to update:");
            int sId = sc.nextInt();
            Dao.updateData(sId);

            System.out.println("Student data updated successfully.");
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a valid student ID.");
            sc.nextLine();
        }
    }
}
            
