package io.syansoft.util;

public class URLMappings {
    public static final String PREFIX = "/api/v1";

    //Student
    public static final String STUDENTS  =PREFIX + "/students";
    public static final String GET_ALL_STUDENTS ="/getAllStudents";
    public static final String ADD_STUDENTS = "/addStudents";

    //Teacher
    public static final String TEACHER =PREFIX + "/teacher" ;
    public static final String GET_ALL_TEACHERS ="/getAllTeacher" ;

    public static final String ADD_TEACHERS =  "/addTeachers";

    //Admin
    public static final String ADMIN = PREFIX + "/admin" ;
    public static final String EDIT_STUDENT = "/editStudent" ;
    public static final String EDIT_TEACHER = "/editTeacher" ;

    //Subject
    public static final String SUBJECT = PREFIX + "/subject";
    public static final String GET_ALL_SUBJECTS = "/getAllSubjects";
    public static final String ADD_SUBJECTS = "/addSubjects";

    //Auth
    public static final String AUTH = "/auth";

    //User
    public static final String USER = PREFIX + "/user" ;
}
