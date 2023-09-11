package io.syansoft.service;

import io.syansoft.domain.Teacher;
import io.syansoft.domain.Teacher;
import io.syansoft.domain.User;
import io.syansoft.dto.TeacherDTO;
import io.syansoft.repository.TeacherRepository;
import io.syansoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TeacherService implements TeacherServiceI{

    @Autowired private TeacherRepository teacherRepository;

    @Autowired private UserRepository userRepository;
    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher addTeacher(TeacherDTO teacherDTO) {
        Teacher teacherDB  = teacherRepository.findByEmail(teacherDTO.getEmailId());
        User userDb = userRepository.findByEmail(teacherDTO.getEmailId());
        if(Objects.isNull(teacherDB) && Objects.isNull(userDb)){
            Teacher teacher = new Teacher();
            teacher.setEmail(teacherDTO.getEmailId());
            teacher.setFirstName(teacherDTO.getFirstName());
            teacher.setLastName(teacherDTO.getLastName());
                User user = new User();
                user.setUserName(teacherDTO.getEmailId());
                user.setEmail(teacherDTO.getEmailId());
                user.setPassword(teacherDTO.getPassword());
                userRepository.save(user);
                return teacherRepository.save(teacher);
        }
        return null;
    }

    @Override
    public Teacher editTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = teacherRepository.findByEmail(teacherDTO.getEmailId());
        if(!Objects.isNull(teacher)){
            teacher.setFirstName(teacherDTO.getFirstName());
            teacher.setLastName(teacherDTO.getLastName());
            teacherRepository.save(teacher);
            return teacher;
        }
        return null;
    }
}
