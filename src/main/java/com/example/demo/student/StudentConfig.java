package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student ck = new Student(
                    "Chahat Kalsi",
                    "chahat.ck88@gmail.com",
                    LocalDate.of(2001, Month.FEBRUARY, 8),
                    21
            );
            Student xyz = new Student(
                    "Ex Why Zed",
                    "xyz@abc.com",
                    LocalDate.of(2001, Month.DECEMBER, 8),
                    21
            );
            // created 2 entries for the db table student
            // saving those entries in the db
            repository.saveAll(
                    List.of(ck, xyz)
            );

        };
    }
}
