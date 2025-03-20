package com.ql.jpa_database_connection.repository;

import com.ql.jpa_database_connection.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    boolean existsByEmail(String email);
}
