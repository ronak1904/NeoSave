package com.example.neosave.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.neosave.exception.ResourceDuplicateException;
import com.example.neosave.exception.ResourceNotFoundException;
import com.example.neosave.model.Student;
import com.example.neosave.repository.StudentRepository;
import com.example.neosave.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveEmployee(Student student) {
		List<Student> allStudent = studentRepository.findAll();
		for(int i=0;i<allStudent.size();i++)
		{
			if(allStudent.get(i).getEmailId().equals(student.getEmailId()))
			{
				throw new ResourceDuplicateException("Student", "Duplicate email id", student.getEmailId());
			}
		}
		return studentRepository.save(student);
	}

	@Override
	public Student getEmployeeById(long id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) {
			return student.get();
		}else {
			throw new ResourceNotFoundException("Student", "Id", id);
		}
		
	}

	

}
