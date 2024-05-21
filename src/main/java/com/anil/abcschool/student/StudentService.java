package com.anil.abcschool.student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student findStudentDetailsById(Integer studentId);

    Boolean deleteStudentById(Integer studentId);

    Student addNewStudent(Student student);

    Student updateStudentDetails(Student student);
}
