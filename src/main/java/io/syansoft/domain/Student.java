package io.syansoft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor @NoArgsConstructor
public class Student extends User{
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


}
