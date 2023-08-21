package io.syansoft.service;

import io.syansoft.domain.Student;
import io.syansoft.dto.StudentDTO;
import io.syansoft.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentServiceI {

    @Autowired @Lazy
    StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setEmail(studentDTO.getEmailId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
//        student.setRollNo();
        return studentRepository.save(student);
    }

    @Override
    public Student editStudent(StudentDTO studentDTO) {
        Student student = studentRepository.findByEmail(studentDTO.getEmailId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setRollNo(studentDTO.getRollNo());
        studentRepository.save(student);
        return student;
    }
}
