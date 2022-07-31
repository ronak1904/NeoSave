package com.example.neosave.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.neosave.model.Response;
import com.example.neosave.model.Student;
import com.example.neosave.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/user")
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// build create  REST API
	@PostMapping("/create")
	public ResponseEntity<Student> saveEmployee(@RequestBody Student student){
		String uri = "https://api.postalpincode.in/pincode/";
		uri += student.getAddressPincode();
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		Response[] result = restTemplate.getForObject(uri, Response[].class);
		student.setStateName(result[0].getPostOffice().get(0).getState());

		return new ResponseEntity<Student>(studentService.saveEmployee(student), HttpStatus.CREATED);
	}
	
	// build get by id REST API
	@GetMapping("/{id}")
	public ResponseEntity<Student> getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<Student>(studentService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
}
