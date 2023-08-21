package io.syansoft.service;

import io.syansoft.domain.Student;
import io.syansoft.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;

public class StudentService implements StudentServiceI {

    @Autowired @Lazy
    StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
