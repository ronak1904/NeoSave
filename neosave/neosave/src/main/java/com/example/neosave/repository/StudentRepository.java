package com.example.neosave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.neosave.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long>{

}
