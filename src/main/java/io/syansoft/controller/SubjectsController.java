package io.syansoft.controller;

import io.syansoft.domain.Subjects;
import io.syansoft.service.SubjectsServiceI;
import io.syansoft.util.URLMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(URLMappings.SUBJECT)
public class SubjectsController {

@Autowired private SubjectsServiceI subjectsServiceI;
    @GetMapping(URLMappings.GET_ALL_SUBJECTS)
    public List<Subjects> getAllSubjects(){
        return subjectsServiceI.getAllSubjects();
    }
    @PostMapping(URLMappings.ADD_SUBJECTS)
    public Subjects addSubject(@RequestBody Subjects subjects){
        return subjectsServiceI.addSubjects(subjects);
    }

}
