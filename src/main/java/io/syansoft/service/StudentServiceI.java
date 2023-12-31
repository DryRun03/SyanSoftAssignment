package io.syansoft.service;

import io.syansoft.domain.Student;
import io.syansoft.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentServiceI {

    public List<Student> getAllStudents();

    public Student addStudent(StudentDTO studentDTO);

    public Student editStudent(StudentDTO studentDTO);
}
