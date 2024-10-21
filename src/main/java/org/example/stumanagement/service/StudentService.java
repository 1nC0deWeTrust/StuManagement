package org.example.stumanagement.service;

import org.example.stumanagement.pojo.PageResult;
import org.example.stumanagement.pojo.Student;

import java.util.List;

public interface StudentService {
    PageResult<Student> queryStudents(String name, String degree, String clazzId, Integer page, Integer pageSize);

    void addStudent(Student student);

    Student getStudentById(Integer id);

    void setStudent(Student student);

    void removeStudents(List<Integer> ids);

    void setViolation(Integer id, Short score);
}
