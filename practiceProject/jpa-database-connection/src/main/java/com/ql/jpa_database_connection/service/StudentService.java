package com.ql.jpa_database_connection.service;

import com.ql.jpa_database_connection.model.Student;
import com.ql.jpa_database_connection.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private  StudentRepository studentRepository;

    public List<Student> getAllStudents(){
          return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
           if(studentRepository.existsById(id)) {
                 Optional<Student> existingStudent=studentRepository.findById(id);
                  try{
                     return existingStudent.get();
                  }catch (NoSuchElementException ex){
                     throw new NoSuchElementException(ex.getMessage());
                  }
           }
             throw new RuntimeException("User not found with particular id "+id);
    }

    public Student saveStudent(Student student){
          String email=student.getEmail();
          if(!studentRepository.existsByEmail(email.toLowerCase())){
              return studentRepository.save(student);
          }else{
              throw new RuntimeException("User already present with this particular email");
          }
    }

    public void deleteStudentById(Long id){
         if(studentRepository.existsById(id)){
             studentRepository.deleteById(id);
         }else{
             throw new RuntimeException("User not found with particular id "+id);
         }
    }

    public Student updateStudentById(Long id,Student updatedStudent){
              Optional<Student> ExistingStudent=studentRepository.findById(id);
             if(ExistingStudent.isPresent()){
                      Student student= ExistingStudent.get();
                      student.setName(updatedStudent.getName());
                      student.setEmail(updatedStudent.getEmail());
                      return studentRepository.save(student);
             }else{
                 throw new RuntimeException("User not found with particular id "+id);
             }

    }
}
