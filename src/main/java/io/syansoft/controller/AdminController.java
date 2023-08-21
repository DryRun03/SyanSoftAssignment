package io.syansoft.controller;

import io.syansoft.domain.Student;
import io.syansoft.domain.Teacher;
import io.syansoft.dto.StudentDTO;
import io.syansoft.dto.TeacherDTO;
import io.syansoft.service.StudentService;
import io.syansoft.service.StudentServiceI;
import io.syansoft.service.TeacherService;
import io.syansoft.service.TeacherServiceI;
import io.syansoft.util.URLMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(URLMappings.ADMIN)
public class AdminController {

    @Autowired private StudentService studentService;
    @Autowired private TeacherServiceI teacherService;

    @PutMapping(URLMappings.EDIT_STUDENT)
    public Student editStudent(@RequestBody StudentDTO studentDTO){
        return studentService.editStudent(studentDTO);
    }


    @PutMapping(URLMappings.EDIT_TEACHER)
    public Teacher editTeacher(@RequestBody TeacherDTO teacherDTO){
        return teacherService.editTeacher(teacherDTO);
    }

    @PostMapping(URLMappings.ADD_TEACHERS)
    public Teacher addTeacher(@RequestBody TeacherDTO teacherDTO){
        return teacherService.addTeacher(teacherDTO);
    }

    @PostMapping(URLMappings.ADD_STUDENTS)
    public Student addStudent(@RequestBody StudentDTO studentDTO){
        return studentService.addStudent(studentDTO);
    }
}
