package org.example.stumanagement.service;

import org.example.stumanagement.pojo.StudentCountData;

import java.util.List;
import java.util.Map;

public interface ReportService {

    StudentCountData getStudentCountData();

    List<Map> getStudentDegreeData();
}
