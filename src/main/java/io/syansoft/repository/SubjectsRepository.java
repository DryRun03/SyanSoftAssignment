package io.syansoft.repository;

import io.syansoft.domain.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SubjectsRepository extends JpaRepository<Subjects,Integer>{
    public Subjects findBySubjectCode(String subjectCode);
}
