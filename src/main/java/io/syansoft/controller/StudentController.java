package io.syansoft.controller;

import io.syansoft.domain.Student;
import io.syansoft.dto.StudentDTO;
import io.syansoft.service.StudentServiceI;
import io.syansoft.util.URLMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(URLMappings.STUDENTS)
public class StudentController {

    @Autowired
    private StudentServiceI studentService;

    @GetMapping(URLMappings.GET_ALL_STUDENTS)
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping(URLMappings.ADD_STUDENTS)
    public Student addStudent(@RequestBody StudentDTO studentDTO){
        return studentService.addStudent(studentDTO);
    }

}
