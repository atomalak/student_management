package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.StudentsService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentsService studentService;

	@GetMapping("get-all-students")
	public ResponseEntity<?> getAllStudents() {
		return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
	}
	
	@GetMapping("filter-students-with-id")
	public ResponseEntity<?> filterStudentsWithId(@RequestParam("id") int id) {
		return new ResponseEntity<>(studentService.filterStudentsWithId(id), HttpStatus.OK);
	}
	
	@GetMapping("filter-students-with-id-path-param/{id}")
	public ResponseEntity<?> filterStudentsWithIdPathParam(@PathVariable("id") int id) {
		return new ResponseEntity<>(studentService.filterStudentsWithId(id), HttpStatus.OK);
	}

}
