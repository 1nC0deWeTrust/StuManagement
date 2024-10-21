package org.example.stumanagement.service.impl;

import jakarta.annotation.Resource;
import org.example.stumanagement.mapper.ReportMapper;
import org.example.stumanagement.pojo.StudentCountData;
import org.example.stumanagement.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportMapper reportMapper;

    @Override
    public StudentCountData getStudentCountData() {
        List<Map<String, Object>> list = reportMapper.getStudentCountData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("clazz")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new StudentCountData(jobList, dataList);
    }

    @Override
    public List<Map> getStudentDegreeData() {
        return reportMapper.getStudentDegreeData();
    }
}
