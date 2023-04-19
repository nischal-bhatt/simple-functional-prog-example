package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @PostMapping("/students")
    public Map<String, Student> getStudents(@RequestBody RequestClass requestClass) {
        List<Student> students = requestClass.getStudentList();

        return students.stream().filter(student -> student.getAge() == 4)
                .collect(Collectors.toMap(Student::getName, Function.identity()));


    }
}
