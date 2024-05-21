package com.anil.abcschool.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        var students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudentDetails(@RequestBody Student student){
        var response = studentService.updateStudentDetails(student);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable("id") Integer studentId){
        var student = studentService.findStudentDetailsById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Integer studentId){
        var result = studentService.deleteStudentById(studentId);
        if(result)
            return new ResponseEntity<>("student with given id: " + studentId + " deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>("unable to delete the student details for id: " + studentId, HttpStatus.CONFLICT);
    }

    @PostMapping
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student){
        var response = studentService.addNewStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
