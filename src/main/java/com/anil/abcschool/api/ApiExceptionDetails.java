package com.anil.abcschool.api;

import com.anil.abcschool.school.SchoolDetailsNotFoundException;
import com.anil.abcschool.student.StudentDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionDetails {


    @ExceptionHandler(SchoolDetailsNotFoundException.class)
    public ResponseEntity<ApiExceptionFormat> getSchoolNotFoundExceptionDetails(SchoolDetailsNotFoundException exception){
        ApiExceptionFormat apiExceptionFormat = new ApiExceptionFormat(exception.getMessage(), ZonedDateTime.now());
        return new ResponseEntity<>(apiExceptionFormat, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(StudentDetailsNotFoundException.class)
    public ResponseEntity<ApiExceptionFormat> getStudentNotFoundExceptionDetails(StudentDetailsNotFoundException exception){
        ApiExceptionFormat apiExceptionFormat = new ApiExceptionFormat(exception.getMessage(), ZonedDateTime.now());
        return new ResponseEntity<>(apiExceptionFormat, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ApiExceptionFormat> getSQLExceptionDetails(SQLException exception){
        ApiExceptionFormat apiExceptionFormat = new ApiExceptionFormat(exception.getMessage(), ZonedDateTime.now());
        return new ResponseEntity<>(apiExceptionFormat, HttpStatus.BAD_REQUEST);
    }


}
