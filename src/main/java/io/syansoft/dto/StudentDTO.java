package io.syansoft.dto;

import io.syansoft.domain.UserType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class StudentDTO {
    private String firstName;
    private String lastName;
    private String emailId;
    private Integer rollNo;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private String password;
}
