package com.example.neosave.service;

import com.example.neosave.model.Student;

public interface StudentService {
	
	Student saveEmployee(Student student);
	
	Student getEmployeeById(long id);
	
}
