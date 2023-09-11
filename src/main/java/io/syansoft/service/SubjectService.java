package io.syansoft.service;

import io.syansoft.domain.Subjects;
import io.syansoft.domain.Teacher;
import io.syansoft.repository.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SubjectService implements SubjectsServiceI{

    @Autowired private SubjectsRepository subjectsRepository;
    @Override
    public List<Subjects> getAllSubjects(){
        return subjectsRepository.findAll();
    }

    @Override
    public Subjects addSubjects(Subjects subjects){
        Subjects subjectDB = subjectsRepository.findBySubjectCode(subjects.getSubjectCode());
        if(Objects.isNull(subjectDB))
            return subjectsRepository.save(subjects);
        return null;
    }

    @Override
    public Subjects editSubjects(Subjects subject) {
        Subjects subjectsDB =  subjectsRepository.findBySubjectCode(subject.getSubjectCode());
        if(!Objects.isNull(subjectsDB)){
            subjectsDB.setSubjectCode(subject.getSubjectCode());
            subjectsDB.setName(subject.getName());
            subjectsRepository.save(subjectsDB);
            return subjectsDB;
        }
        return null;
    }
}
