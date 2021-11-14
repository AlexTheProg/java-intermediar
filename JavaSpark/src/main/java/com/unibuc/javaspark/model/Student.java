package com.unibuc.javaspark.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {

    @Id
    private Long id;

    private String lastName;
    private String firstName;
    private String classToFail;

    public Student(Long id, String lastName, String firstName, String classToFail) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.classToFail = classToFail;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getClassToFail() {
        return classToFail;
    }

    public void setClassToFail(String classToFail) {
        this.classToFail = classToFail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id) && lastName.equals(student.lastName) && firstName.equals(student.firstName) && classToFail.equals(student.classToFail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, classToFail);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", classToFail='" + classToFail + '\'' +
                '}';
    }
}
