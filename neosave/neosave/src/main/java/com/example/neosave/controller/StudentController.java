package com.example.neosave.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.neosave.model.Student;
import com.example.neosave.model.PostOffice;
import com.example.neosave.model.Response;
import com.example.neosave.service.StudentService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/user")
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// build create employee REST API
	@PostMapping("/create")
	public ResponseEntity<Student> saveEmployee(@RequestBody Student student){
		String uri = "https://api.postalpincode.in/pincode/";
		uri += student.getAddressPincode();
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		Response[] result = restTemplate.getForObject(uri, Response[].class);
		 //System.out.println(result);
		 
		 //System.out.println(result[0].getPostOffice().get(0).getState());
		 student.setStateName(result[0].getPostOffice().get(0).getState());
		
		 
//		Response[] response = null;
//		try {
//			response = mapper.readValue(result, Response[].class);
//	        
//	        result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
//	        
//	        System.out.println(result.length());
//	        
//			//System.out.println(result);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
        
		return new ResponseEntity<Student>(studentService.saveEmployee(student), HttpStatus.CREATED);
	}
	
	// build get employee by id REST API
	// http://localhost:8080/api/employees/1
	@GetMapping("/{id}")
	public ResponseEntity<Student> getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<Student>(studentService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	

}
