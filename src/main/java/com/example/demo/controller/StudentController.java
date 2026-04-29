package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService svc;

    public StudentController(StudentService svc) {
        this.svc = svc;
    }
    @GetMapping
    public List<Student> getAll() {
        return svc.getAllStdn();
    }
    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return svc.getStdnById(id);
    }
    @PostMapping
    public String addStdn(@RequestBody Student s) {
        svc.addStdn(s);
        return "Student added successfully";
    }
    @PutMapping("/{id}")
    public String updStdn(@PathVariable int id, @RequestBody Student s) {
        svc.updStdn(id, s);
        return "Student updated successfully";
    }

    @DeleteMapping("/{id}")
    public String delStdn(@PathVariable int id) {
        svc.delStdn(id);
        return "Student deleted successfully";
    }
}
