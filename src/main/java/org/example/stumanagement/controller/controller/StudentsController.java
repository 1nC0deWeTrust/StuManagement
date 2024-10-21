package org.example.stumanagement.controller.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.stumanagement.pojo.Result;
import org.example.stumanagement.pojo.Student;
import org.example.stumanagement.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("students")
public class StudentsController {

    @Resource
    private StudentService studentService;

    /**
     * name	否	张三	学员姓名
     * degree	否	1	学历(1:初中,2:高中,3:大专,4:本科,5:硕士,6:博士)
     * clazzId	否	2	班级ID
     * page	是	1	分页查询的页码，如果未指定，默认为1
     * pageSize	是	10	分页查询的每页记录数，如果未指定，默认为10
     */
    @GetMapping
    public Result queryStudents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String degree,
            @RequestParam(required = false) String clazzId,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(studentService.queryStudents(name, degree, clazzId, page, pageSize));
    }

    /**
     * name	string	必须	姓名
     * no	string	必须	学号
     * gender	number	必须	性别
     * phone	string	必须	手机号
     * degree	number	必须	学历(1:初中,2:高中,3:大专,4:本科,5:硕士,6:博士)
     * clazzId	number	必须	班级ID
     * idCard	string	非必须	身份证号
     * isCollege	number	非必须	是否是院校学生 (1: 是, 0: 否)
     * address	string	非必须	联系地址
     * graduationDate	string	非必须	毕业时间
     */
    @PostMapping
    public Result addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return Result.success();
    }

    /**
     * id	number	必须	学员ID
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result getStudentById(@PathVariable Integer id) {
        Student student = studentService.getStudentById(id);
        return Result.success(student);
    }

    /**
     * id	number	必须	id
     * name	string	必须	姓名
     * no	string	必须	学号
     * phone	string	必须	手机号
     * gender	string	必须	性别(1:男, 2:女)
     * degree	number	必须	学历(1:初中,2:高中,3:大专,4:本科,5:硕士,6:博士)
     * idCard	string	非必须	身份证号
     * isCollege	number	非必须	是否是院校学生 (1: 是, 0: 否)
     * address	string	非必须	联系地址
     * graduationDate	string	非必须	毕业时间
     * violationCount	number	必须	违纪次数
     * violationScore	number	必须	违纪扣分
     * clazzId	number	必须	班级ID
     */
    @PutMapping
    public Result setStudent(@RequestBody Student student) {
        studentService.setStudent(student);
        return Result.success();
    }

    /**
     * ids	数组	1	必须	学员的ID数组
     */
    @DeleteMapping("{ids}")
    public Result removeStudents(@PathVariable List<Integer> ids) {
        studentService.removeStudents(ids);
        return Result.success();
    }

    /**
     * id	number	必须	学员ID
     * score	number	必须	扣除分数
     */
    @PutMapping("violation/{id}/{score}")
    public Result setViolation(@PathVariable Integer id, @PathVariable Short score) {
        studentService.setViolation(id, score);
        return Result.success();
    }
}
