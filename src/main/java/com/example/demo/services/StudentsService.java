package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.StudentNotFoundException;
import com.example.demo.models.Students;

@Service
public class StudentsService {
	
	private static List<Students> studentList=new ArrayList<>();
	

	
	public List<Students> getAllStudents(){
		return studentList;
	}
	
	public Students filterStudentsWithId(int id){
		for(Students student:studentList ){
			if(student.getId()==id){
				return student;
			}
		}
		
		throw new StudentNotFoundException("Aradığınız Öğrenci Bulunamadı.");
	}
	
	public void addStudent(Students model){
		studentList.add(model);
	}

}
