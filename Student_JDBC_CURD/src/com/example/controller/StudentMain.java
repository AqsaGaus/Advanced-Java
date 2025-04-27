package com.example.controller;
import java.sql.Connection;
import java.util.Collection;
import java.util.Scanner;
import com.example.service.SimpleQueryExamples;
import com.example.entity.Student;
import com.example.entity.StudentDao;

public class StudentMain
{
/*	
	public static void showAllStudent()
	{
		StudentDao<Student, Integer> dao = new SimpleQueryExamples();
		Collection<Student> studentList = dao.getAll();
		studentList.stream().forEach(stud -> System.out.println(stud));
	}
	
	public static void SearchByRoll()
	{
		StudentDao<Student, Integer> dao = new SimpleQueryExamples();
		Student std = dao.getOne(null);
		if(std != null)
			System.out.println(std);
		else
			System.out.println("Roll Number Does Not Exist.");
	}
*/
	public static void main(String[] args) 
	{
		//showAllStudent();
		Scanner sc= new Scanner(System.in);
		StudentDao<Student, Integer> dao = new SimpleQueryExamples();
		while(true)
		{
			System.out.println("------------- Student Record -------------");
			System.out.println("1. Show All Students"
					+ "\n2. Search A Student By rollNo"
					+ "\n3. Add A Student"
					+ "\n4. Update the Student Record"
					+ "\n5. Delete the Student Record");
			
			System.out.println("Enter Your Choice : ");
			int choice = sc.nextInt();
			
			switch (choice) 
			{
				case 1:
				{
					System.out.println("All Student Detials : ");
					dao.getAll().stream().forEach(stud -> System.out.println(stud));;
					break;
				}
				
				case 2:
				{
					System.out.println("Enter the Rollno you want to Search  : ");
					int roll=sc.nextInt();
					System.out.println(dao.getOne(roll));
					break;
				}
				
				case 3:
				{
					System.out.println("Enter the Rollno name and city : ");
					Student std= new Student(sc.nextInt(),sc.next(),sc.next());
					dao.add(std);
					break;
				}
				
				case 4:
				{
					
					break;
				}
				case 0:
				{
					System.out.println("Thanks for Using our System \nVisit Again...");
					System.exit(0);
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			
		}
	}

}