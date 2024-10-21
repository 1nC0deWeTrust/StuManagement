package org.example.stumanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.stumanagement.pojo.Student;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<Student> selectStudents(String name, String degree, String clazzId, Integer page, Integer pageSize);

    void insertStudent(Student student);

    Student selectStudentById(Integer id);

    void setStudent(Student student);

    void removeStudents(List<Integer> ids);

    void setViolation(Integer id, Short score);
}
