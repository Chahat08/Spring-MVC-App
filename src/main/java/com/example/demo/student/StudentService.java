package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// serves the business logic
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("Another student with this email exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if(studentRepository.existsById(studentId))
            studentRepository.deleteById(studentId);
        else throw new IllegalStateException("student with studentId "+studentId+" does not exist");
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalStateException(
                        "Student with id "+studentId+" does not exist"
                ));

        if(
                name!=null &&
                name.length()>0 &&
                !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(
                email!=null &&
                        email.length()>0 &&
                        !Objects.equals(student.getEmail(), email)){
            student.setEmail(email);
        }
    }
}
