package com.ql.jpa_database_connection.controller;


import com.ql.jpa_database_connection.model.Student;
import com.ql.jpa_database_connection.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/id")
    public Optional<Student> getStudentByParticularId(@RequestParam Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

}
