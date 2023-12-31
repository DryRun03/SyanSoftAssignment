package io.syansoft.repository;

import io.syansoft.domain.Student;
import io.syansoft.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    public Teacher findByEmail(String emailId);
}
