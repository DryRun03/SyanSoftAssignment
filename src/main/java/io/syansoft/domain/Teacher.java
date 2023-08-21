package io.syansoft.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String firstName;
    private String lastName;
    private String emailId;
    @OneToOne
    private Subjects subjects;
}
