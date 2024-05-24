package com.anil.abcschool.student;

import com.anil.abcschool.school.School;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void list_all_students(){
        List<Student> students = new ArrayList<>();
        students.add(
                new Student("anil","dev@gmail.com", new School("abc","hyd", new ArrayList<>())));


        // Mock the calls
        Mockito.when(studentService.getAllStudents()).thenReturn(students);



        Mockito.verify(studentRepository,Mockito.times(1)).findAll();
    }
}