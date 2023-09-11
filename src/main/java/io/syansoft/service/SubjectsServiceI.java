package io.syansoft.service;

import io.syansoft.domain.Subjects;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.util.List;

@Service
public interface SubjectsServiceI {

    public List<Subjects> getAllSubjects();
    public Subjects addSubjects(Subjects subjects);

    public Subjects editSubjects(Subjects subject);
}
