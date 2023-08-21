package io.syansoft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor @NoArgsConstructor
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    @NonNull
    private String firstName;
    private String lastName;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer rollNo;
    @NonNull
    private String email;
    private User user;


}
