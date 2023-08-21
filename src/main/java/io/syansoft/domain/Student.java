package io.syansoft.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String firstName;
    private String lastName;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer rollNo;
    private String email;
    @OneToMany
    private List<Subjects> subjects;
}
