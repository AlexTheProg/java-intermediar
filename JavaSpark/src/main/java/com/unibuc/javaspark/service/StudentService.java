package com.unibuc.javaspark.service;

import com.unibuc.javaspark.model.Student;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    void addStudent(Student student);

    List<Student> getAllStudents();

    Optional<Student> getStudentById(String id);

    Student editStudent(Student student);

    void deleteStudent(String id);
}
