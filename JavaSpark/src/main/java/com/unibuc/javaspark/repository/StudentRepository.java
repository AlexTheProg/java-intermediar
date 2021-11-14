package com.unibuc.javaspark.repository;

import com.unibuc.javaspark.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByFirstName(String firstName);
    Student findStudentByLastName(String lastName);
    Student findStudentByClassToFail(String classToFail);

    Optional<Student> findById(String id);

    void deleteById(String id);
}
