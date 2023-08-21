package io.syansoft.service;

import io.syansoft.domain.Teacher;
import io.syansoft.dto.TeacherDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherServiceI {

    public List<Teacher> getAllTeacher();

    public Teacher addTeacher(TeacherDTO teacherDTO);
}
