package org.example.stumanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.example.stumanagement.mapper.StudentMapper;
import org.example.stumanagement.pojo.PageResult;
import org.example.stumanagement.pojo.Student;
import org.example.stumanagement.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> queryStudents(String name, String degree, String clazzId, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        List<Student> students = studentMapper.selectStudents(name, degree, clazzId, page, pageSize);

        PageResult<Student> pageResult = new PageResult<>();
        pageResult.setTotal((int) new PageInfo<>(students).getTotal());
        pageResult.setRows(students);

        return pageResult;
    }

    @Override
    public void addStudent(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(student.getCreateTime());
        studentMapper.insertStudent(student);
    }

    @Override
    public Student getStudentById(@PathVariable Integer id) {
        return studentMapper.selectStudentById(id);
    }

    @Override
    public void setStudent(Student student) {
        studentMapper.setStudent(student);
    }

    @Override
    public void removeStudents(List<Integer> ids) {
        studentMapper.removeStudents(ids);
    }

    @Override
    public void setViolation(Integer id, Short score) {
        studentMapper.setViolation(id, score);
    }
}
