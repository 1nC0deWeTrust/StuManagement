package org.example.stumanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {
    List<Map<String, Object>> getStudentCountData();

    List<Map> getStudentDegreeData();
}
