package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Data Access Layer, an interface, which extends jparepository<table_type, id_type>
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
