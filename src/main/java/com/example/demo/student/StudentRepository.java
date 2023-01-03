package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Data Access Layer, an interface, which extends jparepository<table_type, id_type>
@Repository // repository is the one that directly communicates with the db, via settings defined in config
public interface StudentRepository extends JpaRepository<Student, Long> {

    // JPQL, not sql
    @Query("SELECT s FROM Student s WHERE s.email=?1")
    Optional<Student> findStudentByEmail(String email);
    // above runs the foll sql statement
    // SELECT * FROM student WHERE email = ?

}
