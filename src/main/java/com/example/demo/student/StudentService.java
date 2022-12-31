package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// serves the business logic
@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Chahat Kalsi",
                        "chahat.ck88@gmail.com",
                        LocalDate.of(2001, Month.JANUARY, 8),
                        21
                )
        );
    }
}
