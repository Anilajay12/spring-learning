package com.anil.abcschool.student;

import com.anil.abcschool.school.School;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @Column(updatable = false, unique = true)
    @Email(message = "please enter valid email id")
    private String email;


    @OneToMany
    private School school;


    public Student() {
    }

    public Student(String name, String email, School school) {
        this.name = name;
        this.email = email;
        this.school = school;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
