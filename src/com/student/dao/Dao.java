package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.student.manage.ConnectionProvider;
import com.student.manage.Student;

public class Dao {

	
	public static void insertStud(Student student) {
		
		try {
		Connection con = ConnectionProvider.createC();
		String q = "insert into student_manage(sname,sphone,scity) values(?,?,?)";
		PreparedStatement pstmt =  con.prepareStatement(q);
		
//		pstmt.setInt(1, student.getsId());
		pstmt.setString(1, student.getsName());
		pstmt.setString(2, student.getPhoneNum());
		pstmt.setString(3, student.getsCity());
		
		pstmt.executeUpdate();
	
		}catch (InputMismatchException e) {
			System.out.println("please enter Number Only");
		}
		catch(Exception e) {
			System.out.println("Please enter id again cause it is primary and already used by someone");
		}
	}
	public static void deleteStud(int sId) {
		try {
			Connection con = ConnectionProvider.createC();
			String q= "delete from student_manage where id = ?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, sId);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("please try again");
		}
	}
	public static void ShowAllStudents() {
		
		try {
			Connection con = ConnectionProvider.createC();
			String q = "SELECT * FROM student_manage order BY id ASC";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			
			System.out.println("id\tname\t\t\tphone\t\t\t\t\tcity");
			System.out.println("----------------------------------------------------------------------------");
			while(rs.next()) {
				int id =rs.getInt(1);
				String name =rs.getString(2);
				long phone = rs.getLong(3);
				String city = rs.getString(4);
				System.out.println(id+"\t"+name+"\t\t\t"+phone+"\t\t\t\t"+city);
			}
			
		} catch (SQLException e) {
			System.out.println("please try again");
		}
		
	}
	public static void updateData(int sId) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What you want to update for "+sId);
		System.out.println("To update name press 1");
		System.out.println("To update phone Number press 2");
		System.out.println("To update city details press 3");
		
		 int choice = sc.nextInt();
	
		try {
			Connection con = ConnectionProvider.createC();
			if(choice==1) {
				
				System.out.println();
				System.out.println("Enter name to update ");
				String name = sc.next();
				String q = "update student_manage set sname ='"+name+ "' where Id ="+sId;
				Statement stmt = con.createStatement();
				stmt.executeQuery(q);
				
			}else if(choice==2) {
				System.out.println();
				System.out.println("Enter Phone number to update ");
				long phone = sc.nextLong();
				String q = "update student_manage set sphone ="+phone+ " where Id ="+sId;
				Statement stmt = con.createStatement();
				stmt.executeQuery(q);
				
			}else if(choice==3) {
				System.out.println();
				System.out.println("Enter City to update ");
				String city = sc.next();
				String q = "update student_manage set scity ='"+city+"' where Id ="+sId;
				Statement stmt = con.createStatement();
				stmt.executeQuery(q);
			}
		
			
		} catch (Exception e) {
			System.out.println("please try again");
		}
	}
}
