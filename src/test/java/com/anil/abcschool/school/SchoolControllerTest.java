package com.anil.abcschool.school;

import org.junit.jupiter.api.*;

class SchoolControllerTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("before class");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after class");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("before each method");
    }

    @Test
    void testMethod1(){
        System.out.println("test1");
    }

    @Test
    void testMethod2(){
        System.out.println("test2");
    }

    @AfterEach
    void tearDown() {
        System.out.println("post");
    }
}