package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbc;

    public StudentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private RowMapper<Student> rm = (rs, rowNum) -> {
        Student s = new Student();
        s.setId(rs.getInt("id"));
        s.setName(rs.getString("name"));
        s.setEmail(rs.getString("email"));
        s.setCourse(rs.getString("course"));
        return s;
    };

    public List<Student> getAll() {
        String sql = "SELECT * FROM student";
        return jdbc.query(sql, rm);
    }

    public Student getById(int id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        return jdbc.queryForObject(sql, rm, id);
    }

    public int add(Student s) {
        String sql = "INSERT INTO student (name, email, course) VALUES (?, ?, ?)";
        return jdbc.update(sql, s.getName(), s.getEmail(), s.getCourse());
    }

    public int upd(int id, Student s) {
        String sql = "UPDATE student SET name = ?, email = ?, course = ? WHERE id = ?";
        return jdbc.update(sql, s.getName(), s.getEmail(), s.getCourse(), id);
    }

    public int del(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        return jdbc.update(sql, id);
    }
}
