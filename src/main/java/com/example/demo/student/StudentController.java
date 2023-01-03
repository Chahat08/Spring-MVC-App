package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value="") // creating an endpoint, return val if list (or collection) -> we get json back
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    // POST is used when adding new resources to our db
    // adding new student here
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){ // RequestBody for getting a request from a client
        studentService.addNewStudent(student);
    }

    // DELETE is used to delete existing resources from the db
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long StudentId){
        studentService.deleteStudent(StudentId);
    }

    // PUT is used when we want to update an existing entry in the db
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId){
        studentService.updateStudent(studentId);
    }

    /*
    {
	"name":"bilal",
    "email":"bilal@gmail.com",
    "dob":"1995-12-17"
}
     */
}
