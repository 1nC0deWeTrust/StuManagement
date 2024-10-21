package org.example.stumanagement.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.stumanagement.pojo.Result;
import org.example.stumanagement.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("report")
public class ReportController {

    @Resource
    private ReportService reportService;

    @GetMapping("studentCountData")
    public Result getStudentCountData() {
        return Result.success(reportService.getStudentCountData());
    }

    @GetMapping("studentDegreeData")
    public Result getStudentDegreeData() {
        return Result.success(reportService.getStudentDegreeData());
    }
}
