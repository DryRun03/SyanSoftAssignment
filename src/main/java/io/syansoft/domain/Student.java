package io.syansoft.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String firstName;
    private String lastName;
    private Integer rollNo;
    private String email;
    @OneToMany
    private Subjects subjects;
}
