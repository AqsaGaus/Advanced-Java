package com.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.example.entity.Student;
import com.example.entity.StudentDao;
import com.example.util.StudentUtils;

public class SimpleQueryExamples implements StudentDao<Student, Integer>
{

	public SimpleQueryExamples() 
	{
		
	}

	@Override
	public Collection<Student> getAll() 
	{
		Collection<Student> allStudents = new ArrayList<Student>();
		try(
				Connection dbConnection = StudentUtils.buildConnection();
				Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery("select * from student");
			)
		{
			while(rs.next())
			{
				int roll = rs.getInt(1);
				String name = rs.getString(2);
				String city = rs.getString(3);
				
				Student st = new Student(roll,name,city);
				allStudents.add(st);
			}
		}
		 catch (Exception e) {
			 e.printStackTrace();
		}
		return allStudents;
	}

	@Override
	public Student getOne(Integer rollNo) 
	{
		Student foundroll = null;
		String sqlQuery = "select * from student where id = ?";
		
		try(
				Connection dbConnection = StudentUtils.buildConnection();
				PreparedStatement psmt = dbConnection.prepareStatement(sqlQuery)
			)
		{
			psmt.setInt(1, rollNo);
			ResultSet rs = psmt.executeQuery();
			if(rs.next())
			{
				int roll = rs.getInt(1);
				String name = rs.getString(2);
				String city = rs.getString(3);
				foundroll = new Student(roll, name, city);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return foundroll;
	}

	@Override
	public void add(Student t) 
	{
		String sqlQuery = "insert into student values(?,?,?)";
		try(
				Connection dbConnection = StudentUtils.buildConnection();
				PreparedStatement psmt = dbConnection.prepareStatement(sqlQuery)
			)
		{
				
				int roll = t.getRoll();
				String name = t.getName();
				String city = t.getCity();
				
				psmt.setInt(1, roll);
				psmt.setString(2, name);
				psmt.setString(3, city);
				
				int updateCount = psmt.executeUpdate();
				System.out.println(updateCount +" record inserted");
				
	
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

	@Override
	public void update(Student t) 
	{
		
		
	}

	@Override
	public void delete(Integer k) 
	{
		
		
	}

	
}
