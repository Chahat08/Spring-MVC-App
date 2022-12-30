package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController // DemoApplication can now serve endpoints
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping(value="/") // creating an endpoint, return val if list (or collection) -> we get json back
	public List<Student> hello(){
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
