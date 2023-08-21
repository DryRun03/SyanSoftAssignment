package io.syansoft.service;

import io.syansoft.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentServiceI {
    public List<Student> getAllStudents();


}
