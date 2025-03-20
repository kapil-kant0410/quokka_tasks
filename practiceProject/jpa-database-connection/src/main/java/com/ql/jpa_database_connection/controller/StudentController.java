package com.ql.jpa_database_connection.controller;
import com.ql.jpa_database_connection.model.Student;
import com.ql.jpa_database_connection.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.Min;

import java.util.List;
import java.util.NoSuchElementException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student){
        try{
            Student createdStudent=studentService.saveStudent(student);
            return ResponseEntity.ok(createdStudent);
        }catch (RuntimeException ex){
              return ResponseEntity.ok(ex.getMessage());
        }
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<?> getStudents(){
          List<Student> studentList= studentService.getAllStudents();
          if(studentList.isEmpty()){
                return ResponseEntity.ok("No student present in the database.");
          }
          return ResponseEntity.ok(studentList);
    }

    @GetMapping("/getStudentWithParticularId/{id}")
    public ResponseEntity<?> getStudentByParticularId(@PathVariable Long id){
          try{
             Student student =studentService.getStudentById(id);
             return ResponseEntity.ok(student);
          }catch (NoSuchElementException ex){
             return ResponseEntity.status(404).body(ex.getMessage());
          } catch (RuntimeException ex){
             return  ResponseEntity.status(404).body(ex.getMessage());
          }

    }

    @DeleteMapping("/deleteStudentWithParticularId/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
          try{
                studentService.deleteStudentById(id);
                return ResponseEntity.ok("User deleted successfully "+id);
          }catch (RuntimeException ex){
              return ResponseEntity.status(404).body("Error: "+ex.getMessage());
          }
    }

    @PutMapping("/updateStudentWithParticularId/{id}")
    public ResponseEntity<String> updateStudentWithParticularId(@PathVariable Long id, @Valid @RequestBody Student updatedStudent){
        try{
               Student student=studentService.updateStudentById(id,updatedStudent);
               return ResponseEntity.ok("User updated successfully "+id);
        }catch(RuntimeException ex){
               return ResponseEntity.status(404).body("Error: "+ex.getMessage());
        }
    }

}
