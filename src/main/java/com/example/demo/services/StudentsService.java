package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Students;

@Service
public class StudentsService {
	
	private static List<Students> studentList=new ArrayList<>();
	
	private void fillStudentList(){
		studentList.add(Students.builder().id(1).name("Ahmet").surname("Çakar").birthDay(LocalDateTime.now()).password("1234")
				.build());

		studentList.add(Students.builder().id(2).name("Muhammed").surname("Güngörmüş").birthDay(LocalDateTime.now())
				.password("1234").build());
		
		studentList.add(Students.builder().id(3).name("Taha").surname("Tomalak").birthDay(LocalDateTime.now())
				.password("1234").build());
		
		studentList.add(Students.builder().id(4).name("Serdar").surname("Başkan").birthDay(LocalDateTime.now())
				.password("1234").build());
		
	}
	
	public List<Students> getAllStudents(){
		fillStudentList();
		return studentList;
	}
	
	public Students filterStudentsWithId(int id){
		fillStudentList();
		for(Students student:studentList ){
			if(student.getId()==id){
				return student;
			}
		}
		
		return null;
	}

}
