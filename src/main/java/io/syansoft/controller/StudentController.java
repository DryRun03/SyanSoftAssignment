package io.syansoft.controller;

import io.syansoft.domain.Student;
import io.syansoft.service.StudentService;
import io.syansoft.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceI studentService;

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
