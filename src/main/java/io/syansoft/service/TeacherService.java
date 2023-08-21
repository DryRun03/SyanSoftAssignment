package io.syansoft.service;

import io.syansoft.domain.Teacher;
import io.syansoft.domain.Teacher;
import io.syansoft.dto.TeacherDTO;
import io.syansoft.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TeacherService implements TeacherServiceI{

    @Autowired private TeacherRepository teacherRepository;
    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher addTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher = teacherRepository.findByEmail(teacherDTO.getEmailId());
        if(Objects.isNull(teacher)){
            teacher.setEmail(teacherDTO.getEmailId());
            teacher.setFirstName(teacher.getFirstName());
            teacher.setLastName(teacher.getLastName());
            return teacherRepository.save(teacher);
        }
        return null;
    }

    @Override
    public Teacher editTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = teacherRepository.findByEmail(teacherDTO.getEmailId());
        teacher.setFirstName(teacherDTO.getFirstName());
        teacher.setLastName(teacherDTO.getLastName());
        teacherRepository.save(teacher);
        return teacher;
    }
}
