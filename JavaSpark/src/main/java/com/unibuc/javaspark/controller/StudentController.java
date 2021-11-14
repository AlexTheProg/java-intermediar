package com.unibuc.javaspark.controller;
import static spark.Spark.*;

import com.google.gson.Gson;
import com.unibuc.javaspark.StandardResponse;
import com.unibuc.javaspark.StatusResponse;
import com.unibuc.javaspark.model.Student;

import com.unibuc.javaspark.service.StudentService;
import com.unibuc.javaspark.service.StudentServiceImpl;


public class StudentController {



    public static void main(String[] args) {
        final StudentService studentService = new StudentServiceImpl();

        //add a student
        post("/students", ((request, response) -> {
            response.type("application/json");
            Student student = new Gson().fromJson(request.body(), Student.class);
            studentService.addStudent(student);
            return new Gson()
                    .toJson(new StandardResponse(StatusResponse.SUCCESS));
        }));

        //get all students
        get("/students", ((request, response) -> {
            response.type("application/json");
            return new Gson()
                    .toJson(
                            new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(studentService.getAllStudents()))
                    );
        }));

        //get student by id
        get("students/:id", ((request, response) -> {
            response.type("application/json");
            return new Gson()
                    .toJson(
                            new StandardResponse(StatusResponse.SUCCESS, new Gson()
                                    .toJsonTree(studentService.getStudentById(request.params(":id"))))
                    );
        }));

        //edit student
        put("/students/:id", ((request, response) -> {
            response.type("application/json");
            Student toEdit = new Gson().fromJson(request.body(), Student.class);
            Student editedStudent = studentService.editStudent(toEdit);

            if(editedStudent != null){
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.SUCCESS, new Gson()
                                .toJsonTree(editedStudent))
                );
            }else{
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.ERROR, new Gson()
                                .toJson("User not found or there was an error during the edit of the student"))
                );
            }

        }));

        //delete a student
        delete("/students/:id", (request, response) -> {
            response.type("application/json");
            studentService.deleteStudent(request.params(":id"));
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, "user deleted")
            );
        });



    }
}
