package com.unibuc.javaspark.service;

import com.unibuc.javaspark.model.Student;
import com.unibuc.javaspark.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;


    @Override
    public void addStudent(Student student) {
        if(student.getFirstName().isEmpty() || student.getLastName().isEmpty()){
            System.out.println("The student must have both names in order to participate in the courses");
            return;
        }
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String id) {
        if(studentRepository.findById(id).isEmpty()){
            System.out.println("oopsie daisy");
            return;
        }
        studentRepository.deleteById(id);
    }

}
