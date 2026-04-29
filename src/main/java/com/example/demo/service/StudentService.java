package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAllStdn() {
        return repo.getAll();
    }

    public Student getStdnById(int id) {
        return repo.getById(id);
    }

    public int addStdn(Student s) {
        return repo.add(s);
    }

    public int updStdn(int id, Student s) {
        return repo.upd(id, s);
    }

    public int delStdn(int id) {
        return repo.del(id);
    }
}
