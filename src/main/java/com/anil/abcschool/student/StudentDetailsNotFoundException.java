package com.anil.abcschool.student;

public class StudentDetailsNotFoundException extends RuntimeException{
    public StudentDetailsNotFoundException(String message){
        super(message);
    }
}
