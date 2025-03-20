package com.ql.jpa_database_connection.model;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.Constraint.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="students")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    public Student() {};

    public Student(String name,String email){
        this.name=name;
        this.email=email;
    }

    public Long getId(){
          return this.id;
    }

    public void setId(Long id){
         this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
         this.name=name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

}
