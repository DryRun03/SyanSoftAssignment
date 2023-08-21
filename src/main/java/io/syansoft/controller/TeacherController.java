package io.syansoft.controller;

import io.syansoft.domain.Teacher;
import io.syansoft.dto.TeacherDTO;
import io.syansoft.service.TeacherServiceI;
import io.syansoft.util.URLMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(URLMappings.TEACHER)
public class TeacherController {

    @Autowired private TeacherServiceI teacherService;

    @GetMapping(URLMappings.GET_ALL_TEACHERS)
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeacher();
    }

}
