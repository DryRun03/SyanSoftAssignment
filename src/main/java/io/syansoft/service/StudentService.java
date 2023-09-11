package io.syansoft.service;

import io.syansoft.domain.Student;
import io.syansoft.domain.User;
import io.syansoft.dto.StudentDTO;
import io.syansoft.repository.StudentRepository;
import io.syansoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService implements StudentServiceI {

    @Autowired @Lazy
    StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired UserService userService;
    @Autowired UserRepository userRepository;
    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(StudentDTO studentDTO) {
        Student studentDB = studentRepository.findByEmail(studentDTO.getEmailId());
        User userDB = userRepository.findByEmail(studentDTO.getEmailId());
        if(Objects.isNull(studentDB) && Objects.isNull(userDB)){
            Student student = new Student();
            student.setEmail(studentDTO.getEmailId());
            student.setFirstName(studentDTO.getFirstName());
            student.setLastName(studentDTO.getLastName());
            User user = new User();
            user.setPassword(passwordEncoder.encode(studentDTO.getPassword()));
            user.setUserType(studentDTO.getUserType());
            user.setEmail(studentDTO.getEmailId());
            user.setUserName(studentDTO.getEmailId());
            userRepository.save(user);
            studentRepository.save(student);
            return student;
        }
        return null;
    }

    @Override
    public Student editStudent(StudentDTO studentDTO) {
        Student student = studentRepository.findByEmail(studentDTO.getEmailId());
        if(! Objects.isNull(student)){
            student.setFirstName(studentDTO.getFirstName());
            student.setLastName(studentDTO.getLastName());
            student.setRollNo(studentDTO.getRollNo());
            studentRepository.save(student);
            return student;
        }
        return null;
    }
}
