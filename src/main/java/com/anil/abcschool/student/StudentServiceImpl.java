package com.anil.abcschool.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentDetailsById(Integer studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(
                        () -> new StudentDetailsNotFoundException("unable to find the student details for id: " + studentId)
                );
    }

    @Override
    public Boolean deleteStudentById(Integer studentId) {
        boolean isExists = studentRepository.existsById(studentId);
        if(isExists){
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
    }

    @Override
    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudentDetails(Student student) {
        return studentRepository.saveAndFlush(student);
    }
}
